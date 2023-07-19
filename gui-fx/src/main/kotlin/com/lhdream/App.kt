package com.lhdream

import com.lhdream.view.MainView
import javafx.application.Application
import tornadofx.*
import java.util.Locale

class Apps: App(MainView::class)

fun main(){
    FX.locale = Locale.getDefault()
    println(Locale.getDefault())
    Application.launch(Apps::class.java)
}