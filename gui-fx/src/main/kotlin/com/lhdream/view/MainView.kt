package com.lhdream.view

import com.lhdream.controller.MainController
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import tornadofx.*

/**
 * 主界面
 */
class MainView: View("代码生成工具") {

    val validModel = ViewModel()

    /**
     * 业务实现
     */
    val mainController: MainController by inject()
    /**
     * 数据库ip地址
     */
    val dbServer = validModel.bind { SimpleStringProperty("localhost") }

    /**
     * 数据库连接端口
     */
    val dbPort = validModel.bind { SimpleStringProperty("3306") }

    /**
     * 数据库连接 用户名
     */
    val dbUsername = validModel.bind { SimpleStringProperty("root") }

    /**
     * 数据库连接密码
     */
    val dbPassword = validModel.bind { SimpleStringProperty() }

    /**
     * 数据库名称
     */
    val dbName = validModel.bind { SimpleStringProperty() }

    /**
     * 基础包名
     */
    val groupId = validModel.bind { SimpleStringProperty("com.example") }

    /**
     * 表名前缀
     */
    val tablePrefix = validModel.bind { SimpleStringProperty("tb_") }

    /**
     * 保存位置
     */
    val savePath = validModel.bind { SimpleStringProperty("d://testFile") }

    /**
     * 界面布局
     */
    override val root = anchorpane{
        form {
            fieldset("数据库连接配置:") {
                field("数据库地址") { textfield(dbServer).required() }
                field("数据库端口") { textfield(dbPort).required() }
                field("用户名") { textfield(dbUsername).required() }
                field("密码") { passwordfield(dbPassword).required() }
            }
            fieldset("代码生成配置") {
                field("库名称") { textfield(dbName).required() }
                field("groupId") { textfield(groupId).required() }
                field("表名前缀") { textfield(tablePrefix) }
                field("保存位置") { textfield(savePath).required() }
            }
            buttonbar {
                button("生成") {
                    enableWhen(validModel.valid)
                    action {
                        validModel.commit{
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
}