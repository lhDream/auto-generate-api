import io.github.fvarrui.javapackager.model.RegistryEntry
import io.github.fvarrui.javapackager.model.ValueType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.github.fvarrui.javapackager.gradle.PackageTask

group = "com.lhDream"
version = "1.0.0"
description = "gui-fx"

//val tornadofxVersion = "1.7.20"
val tornadofxVersion = "2.0.0-SNAPSHOT"

plugins {
    id("org.openjfx.javafxplugin").version("0.0.10")
}

dependencies {
    implementation(project(":core"))
    implementation("no.tornado:tornadofx2:$tornadofxVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

javafx{
    version = "17.0.2"
    modules("javafx.base","javafx.controls","javafx.web")
}

tasks.register("auto-generate-api-gui-fx",PackageTask::class.java){
    appName = "auto-generate-api-fx"
    mainClass = "com.lhdream.AppKt"
    isAdministratorRequired = false
    isBundleJre = true
    isCustomizedJre = false
    isCopyDependencies = true
    isGenerateInstaller = true
    platform = io.github.fvarrui.javapackager.model.Platform.windows
    // 虚拟机参数
    vmArgs = ArrayList<String?>().apply {
        this.add("-Xms256M")
    }
    // win配置
    winConfig(null).apply {
        this.headerType = io.github.fvarrui.javapackager.model.HeaderType.gui
        this.isCreateDesktopIconTask = true
        // 是否 隐藏选择安装目录
        this.isDisableDirPage = false
        // 是否 隐藏安装完成界面
        this.isDisableFinishedPage = false
        // 是否 隐藏安装完成后启动程序
        this.isDisableRunAfterInstall = false
        this.isGenerateMsi = false
        this.isGenerateMsm = false
    }
//    additionalResources = ArrayList<File>().also {
//        it.add(File("${project.projectDir}\\src\\main\\resources\\templates"))
//    }
}