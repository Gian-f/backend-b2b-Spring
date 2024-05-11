#!/bin/bash

# Limpar o cache do Docker
docker-compose down --rmi all

# Iniciar os containers usando o Docker Compose
docker-compose up -d

# Verificar se os containers foram iniciados corretamente
docker-compose ps

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "backend-b2b-0.0.1-SNAPSHOT.jar"]

echo "Containers iniciados com sucesso!"
