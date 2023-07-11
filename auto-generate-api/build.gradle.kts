import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.lhdream"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val ktormVersion = "3.6.0"
    val mysqlVersion = "8.0.33"
    val freemarkerVersion = "2.3.32"
    val hutoolVersion = "5.8.16"
    testImplementation(kotlin("test"))
    implementation("org.ktorm:ktorm-core:$ktormVersion")
    implementation("org.ktorm:ktorm-support-mysql:$ktormVersion")
    implementation("com.mysql:mysql-connector-j:$mysqlVersion")
    implementation("org.freemarker:freemarker:$freemarkerVersion")
    implementation("cn.hutool:hutool-all:$hutoolVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}