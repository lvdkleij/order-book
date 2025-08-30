import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
    java
    kotlin("jvm") version "2.2.10"
}

val javaLanguageVersion = "21"

idea {
    project {
        jdkName = javaLanguageVersion
        languageLevel = IdeaLanguageLevel(javaLanguageVersion)
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaLanguageVersion))
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}
