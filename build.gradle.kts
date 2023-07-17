import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("org.openjfx.javafxplugin").version("0.0.10")
}

group = "com.lhdream"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://maven.aliyun.com/repository/central")
    maven(url = "https://maven.aliyun.com/repository/public")
    maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
    maven(url = "https://maven.aliyun.com/repository/apache-snapshots")
    maven(url = "https://maven.aliyun.com/repository/grails-core")
    maven(url = "https://jitpack.io")
    mavenCentral()
}

dependencies {
    val ktormVersion = "3.6.0"
    val mysqlVersion = "8.0.33"
    val freemarkerVersion = "2.3.32"
    val hutoolVersion = "5.8.16"
    val tornadofxVersion = "1.7.20"
    testImplementation(kotlin("test"))
    implementation("org.ktorm:ktorm-core:$ktormVersion")
    implementation("org.ktorm:ktorm-support-mysql:$ktormVersion")
    implementation("com.mysql:mysql-connector-j:$mysqlVersion")
    implementation("org.freemarker:freemarker:$freemarkerVersion")
    implementation("cn.hutool:hutool-all:$hutoolVersion")
    implementation("no.tornado:tornadofx:$tornadofxVersion")
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

javafx{
    version = "17.0.2"
    modules("javafx.base","javafx.controls","javafx.web")
}