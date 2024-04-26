package com.lhdream.view

import tornadofx.*

class TestView : View("My View") {


    override val root = anchorpane {
        button("click me") {
            shortcut("enter")
            action {
                runAsync {
                    // 普通线程
                    val str = "比较耗时的操作"

                    return@runAsync str
                } ui { res ->
                    // UI线程
                    text = res
                }
            }
        }
    }

}
