plugins {
    kotlin("jvm")
    `maven-publish`
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            pom {
                name.set("CatBadge Extension API")
                description.set("API for CatBadge extension development")
            }
        }
    }
    repositories {
        maven {
            val properties = org.jetbrains.kotlin.konan.properties.Properties()
            properties.load(rootProject.file("publish.properties").inputStream())
            url = uri(properties["deployRepoUrl"].toString())
            credentials {
                username = properties["deployRepoUsername"].toString()
                password = properties["deployRepoPassword"].toString()
            }
        }
    }
}
