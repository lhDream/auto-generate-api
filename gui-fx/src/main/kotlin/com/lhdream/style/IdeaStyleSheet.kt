package com.lhdream.style

import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.paint.Color
import tornadofx.*

class IdeaStyleSheet: Stylesheet() {

    private val pane by csselement()
    private val anchorPane by csselement()

    init {
        val defaultBgColor = c("#3C3F41")
        root{
            backgroundInsets = multi(box(0.px))
            backgroundColor += defaultBgColor
            textFill = c("#838E95")
        }
        pane{
            backgroundColor += defaultBgColor
        }
        anchorPane{
            backgroundColor += defaultBgColor
        }
        splitPane{
            backgroundColor += defaultBgColor
            splitPaneDivider{
                padding = box(1.px)
                backgroundColor += c("#838E95")
            }
        }
        text{
            fill = c("#838E95")
        }
        button{
            backgroundColor += c("#4C5052")
            backgroundRadius = multi(box(3.px))
            textFill = c("#838E95")
            borderColor = multi(box(c("#838E95")))
            borderRadius = multi(box(3.px))
            and(focused){
                borderColor = multi(box(c("#4B6EAF")))
            }
        }
        textInput{
            borderColor = multi(box(c("#838E95")))
            backgroundColor += c("#45494A")
            textFill = c("#838E95")
            and(focused){
                borderColor = multi(box(c("#4B6EAF")))
            }
            contextMenu{
                backgroundColor += c("#3C3F41")
                menuItem{
                    and(hover){
                        backgroundColor += c("#4B6EAF")
                    }
                    and(focused){
                        backgroundColor += c("#4B6EAF")
                    }
                }
            }
        }
        textArea{
            borderColor = multi(box(Color.TRANSPARENT))
            backgroundColor += c("#3C3F41")
            content{
                backgroundColor += c("#2B2B2B")
            }
            viewport{
                backgroundColor += c("#2B2B2B")
            }
        }
        checkBox{
            box{
                // 复选框
                backgroundColor += c("#3C3F41")
                borderColor = multi(box(c("#838E95")))
                mark{
                    // 复选框内对钩颜色
                    textFill = c("#838E95")
                }
            }
        }
        // 单选按钮
        toggleButton{
            backgroundColor += c("#3C3F41")
            and(hover){
                backgroundColor += c("#353739")
            }
            and(selected){
                backgroundColor += c("#2D2F30")
            }
        }
        // 单选框
        radioButton{
            radio{
                backgroundColor = multi(c("#838E95"),c("#3C3F41"))
            }
        }
        // 选择框
        choiceBox{
            borderColor = multi(box(c("#838E95")))
            backgroundColor += c("#45494A")
            textFill = c("#838E95")
            and(focused){
                borderColor = multi(box(c("#4B6EAF")))
            }
        }
        // 滑块
        slider{
            track{
                backgroundColor += c("#4E5254")
            }
            thumb{
                backgroundColor += c("#838E95")
            }
        }
        // 进度条
        progressBar{
            track{
                backgroundColor += c("4E5254")
            }
            bar{
                backgroundColor += c("#838E95")
            }
        }
        // 菜单栏
        menuBar{
            backgroundColor += c("#3C3F41")
            menu{
                backgroundColor += c("#3C3F41")
                and(hover){
                    backgroundColor += c("#464A4D")
                }
                and(showing){
                    backgroundColor += c("#4B6EAF")
                }
                contextMenu{
                    backgroundColor += c("#3C3F41")
                }
                menuItem{
                    backgroundColor += c("#3C3F41")
                    and(hover){
                        backgroundColor += c("#4B6EAF")
                    }
                }
            }
        }
        // 滚动条样式
        scrollBar{
            backgroundColor += Color.TRANSPARENT
            thumb{
                backgroundColor += c("#4E4E4E")
                and(hover){
                    backgroundColor += c("#565656")
                }
            }
        }
        listView{
            backgroundColor += c("#3C3F41")
            listCell{
                backgroundColor += c("#3C3F41")
                and(hover){
                    backgroundColor += c("#464A4D")
                }
                and(selected){
                    backgroundColor += c("#4B6EAF")
                }
                and(empty){
                    backgroundColor += c("#3C3F41")
                }
            }
        }
        tableView{
            filler{
                backgroundColor += c("#3C3F41")
            }
            columnHeader{
                backgroundColor += c("#3C3F41")
            }
            backgroundColor += c("#3C3F41")
            tableRowCell{
                backgroundInsets = multi(box(0.px))
                backgroundColor += Color.TRANSPARENT
                borderColor = multi(box(Color.TRANSPARENT))
                and(hover){
                    backgroundColor += c("#464A4D")
                }
                and(selected){
                    backgroundColor += c("#4B6EAF")
                }
            }
            tableColumn{
                borderColor = multi(box(Color.TRANSPARENT))
            }
            placeholder{
                label{
                    fontSize = 32.px
                    text{
                        textFill = c("red")
                    }
                }
            }
        }
        tabPane{
            backgroundInsets = multi(box(0.px))
            tabLabel{
                prefWidth = 100.px
                alignment = Pos.CENTER
            }
            tab{
                prefHeight = 50.px
                prefWidth = 100.px
                alignment = Pos.CENTER
                padding = box(0.px)
                backgroundInsets = multi(box(0.px))
                backgroundColor += c("#3C3F41")
                backgroundRadius = multi(box(0.px))
                textFill = c("#fff")
                and(hover){
                    backgroundColor += c("#27292A")
                    cursor = Cursor.HAND
                }
                and(selected){
                    backgroundColor += c("#4E5254")
                }
                borderWidth = multi(box(0.px))
            }
            treeTableRowCell{
                backgroundInsets = multi(box(0.px))
            }
            tabHeaderBackground{
                backgroundColor += c("#3C3F41")
                padding = box(0.px)
                backgroundInsets = multi(box(0.px))
                prefHeight = 50.px
                maxHeight = 50.px
                minHeight = 50.px
            }
            tabHeaderArea{
                padding = box(0.px)
                backgroundInsets = multi(box(0.px))
                backgroundColor += c("#3C3F41")
            }
            tabContentArea{
                backgroundInsets = multi(box(0.px))
                backgroundColor += defaultBgColor
            }
        }


    }

}