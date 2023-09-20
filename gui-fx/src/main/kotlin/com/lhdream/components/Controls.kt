package com.lhdream.components

import javafx.event.EventTarget
import javafx.scene.paint.Color
import org.kordamp.ikonli.javafx.FontIcon
import tornadofx.*

// FontIcon
fun EventTarget.fontIcon(text: String, iconSize: Int? = null, iconColor:Color? = null, op: FontIcon.() -> Unit = {}) = FontIcon(text).attachTo(this, op){
    if(iconSize != null) it.iconSize = iconSize
    if(iconColor !=null) it.iconColor = iconColor
}