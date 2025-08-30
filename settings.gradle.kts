rootProject.name = "order-book"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(":order-book-event-listener")
project(":order-book-event-listener").projectDir = File("./apps/order-book-event-listener")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}