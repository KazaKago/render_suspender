import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "com.kazakago.render.suspender"
version = "1.0.0"

application {
    mainClass.set("com.kazakago.render.suspender.SuspenderKt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

dependencies {
    implementation("com.typesafe:config:1.4.2")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("org.json:json:20220320")
}
