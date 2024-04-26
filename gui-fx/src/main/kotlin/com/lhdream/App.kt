package com.lhdream

import com.lhdream.style.IdeaStyleSheet
import com.lhdream.view.MainView
import com.lhdream.view.TestView
import javafx.application.Application
import javafx.stage.Stage
import tornadofx.*
import java.util.Locale

class Apps: App(MainView::class,IdeaStyleSheet::class)

fun main(){
    launch<Apps>()
}