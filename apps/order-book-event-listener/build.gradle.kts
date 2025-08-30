plugins {
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-logging")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework:spring-websocket")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.named("jar") {
    enabled = false
}