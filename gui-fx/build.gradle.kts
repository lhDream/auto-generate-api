import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "gui-fx"

val tornadofxVersion = "1.7.20"

plugins {
    id("org.openjfx.javafxplugin").version("0.0.10")
}

dependencies {
    implementation(project(":core"))
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