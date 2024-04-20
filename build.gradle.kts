plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.b2b"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

ext {
    set("springCloudVersion", "2023.0.1")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.auth0:java-jwt:4.4.0")
    implementation("io.jsonwebtoken:jjwt-api:0.12.3")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.4")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.3")
    implementation("org.postgresql:postgresql:42.7.3")
    runtimeOnly("org.postgresql:postgresql:42.7.3")
    implementation ("org.projectlombok:lombok:1.18.26")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.2")
    testImplementation("org.springframework.security:spring-security-test:6.1.5")
}

dependencyManagement {
    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
