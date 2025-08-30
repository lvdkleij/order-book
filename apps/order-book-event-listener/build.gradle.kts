plugins {
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
    application
}

application {
    mainClass.set("eu.roodbaard.orderbook.orderbookeventlistener.ApplicationKt")
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework:spring-websocket")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("jakarta.websocket:jakarta.websocket-api")
    implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client:2.1.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.named("jar") {
    enabled = false
}