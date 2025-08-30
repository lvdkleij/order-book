import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
    idea
    java
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

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaLanguageVersion))
        }
    }
}
