import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.9.22"
}

group = "com.kazakago.render.suspender"
version = "1.0.0"

application {
    mainClass.set("com.kazakago.render.suspender.SuspenderKt")
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation("com.typesafe:config:1.4.3")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("org.json:json:20231013")
}
