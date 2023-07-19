package com.lhdream

import com.lhdream.style.IdeaStyleSheet
import com.lhdream.view.MainView
import javafx.application.Application
import tornadofx.*

class Apps: App(MainView::class, IdeaStyleSheet::class)

fun main(){
    Application.launch(Apps::class.java)
}