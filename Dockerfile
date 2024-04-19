# Use a imagem oficial do OpenJDK 17 como base
FROM openjdk:17-alpine

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos Gradle para o contêiner
COPY ./gradle /app/gradle

# Copia o Gradle Wrapper para o contêiner
COPY ./gradlew /app/

# Converta as quebras de linha do arquivo gradlew para LF
RUN dos2unix /app/gradlew

# Copia os arquivos Gradle Kotlin DSL
COPY ./build.gradle.kts ./settings.gradle.kts /app/

# Copia o resto dos arquivos do projeto
COPY . .

# Define permissões de execução para o Gradle Wrapper
RUN chmod +x ./gradlew

# Compila e constrói o projeto Spring Boot, pulando os testes
RUN ./gradlew build -x test

# Define o diretório de trabalho onde o arquivo JAR está presente
WORKDIR /app/build/libs/

# Expõe a porta 8080 para fora do contêiner
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "backend-b2b-0.0.1-SNAPSHOT.jar"]
