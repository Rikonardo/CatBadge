plugins {
    kotlin("jvm") version "1.7.0"
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.rikonardo.catbadge"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.rikonardo.com/releases")
    }
}

dependencies {
    implementation(project(":badge-api"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("dev.virefire.kson:KSON:1.3.1")
    implementation("dev.virefire.viira:Viira:1.0.3")
    implementation("org.slf4j:slf4j-nop:1.7.36")
    implementation("org.reflections:reflections:0.10.2")
    implementation("org.jfree:jfreesvg:3.4.3")
    implementation("org.sejda.webp-imageio:webp-imageio-sejda:0.1.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.rikonardo.catbadge.MainKt")
}

tasks.getByName("run"){
    (this as JavaExec).workingDir = project.file("run")
}

tasks.build {
    dependsOn(tasks.getByName("shadowJar"))
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("")
}
