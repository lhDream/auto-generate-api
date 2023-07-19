package com.lhdream.view

import com.lhdream.controller.MainController
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import tornadofx.*

/**
 * 主界面
 */
class MainView: View("代码生成工具") {
    /**
     * 业务实现
     */
    val mainController: MainController by inject()
    /**
     * 数据库ip地址
     */
    val dbServer = SimpleStringProperty("localhost")

    /**
     * 数据库连接端口
     */
    val dbPort = SimpleStringProperty("3306")

    /**
     * 数据库连接 用户名
     */
    val dbUsername = SimpleStringProperty("root")

    /**
     * 数据库连接密码
     */
    val dbPassword = SimpleStringProperty()

    /**
     * 数据库名称
     */
    val dbName = SimpleStringProperty("databaseName")

    /**
     * 基础包名
     */
    val groupId = SimpleStringProperty("com.example")

    /**
     * 表名前缀
     */
    val tablePrefix = SimpleStringProperty("tb_")

    /**
     * 保存位置
     */
    val savePath = SimpleStringProperty("d://testFile")

    /**
     * 界面布局
     */
    override val root = anchorpane{

        form {
            fieldset("数据库连接配置:") {
                field("数据库地址") { textfield(dbServer) }
                field("数据库端口") { textfield(dbPort) }
                field("用户名") { textfield(dbUsername) }
                field("密码") { passwordfield(dbPassword) }
            }
            fieldset("代码生成配置") {
                field("库名称") { textfield(dbName) }
                field("groupId") { textfield(groupId) }
                field("表名前缀") { textfield(tablePrefix) }
                field("保存位置") { textfield(savePath) }
            }
            buttonbar {
                button("生成") {
                    action {
                        runCatching {
                            mainController.enter(
                                ip = dbServer.value,
                                port = dbPort.value,
                                username = dbUsername.value,
                                password = dbPassword.value,
                                dbName = dbName.value,
                                groupId = groupId.value,
                                tablePrefix = tablePrefix.value,
                                savePath = savePath.value
                            )
                            alert(
                                type = Alert.AlertType.ERROR,
                                header = "成功",
                                owner = primaryStage
                            )
                        }.getOrElse {
                            it.printStackTrace()
                            alert(
                                type = Alert.AlertType.ERROR,
                                header = it.message.toString(),
                                owner = primaryStage
                            )
                        }
                    }
                }
            }
        }
    }
}