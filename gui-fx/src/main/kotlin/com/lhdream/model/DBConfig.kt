package com.lhdream.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class DBConfig {

    val dbServerProperty = SimpleStringProperty(this,"dbServer","localhost")

    var dbServer by dbServerProperty

}

class DBConfigModel(dbConfig: DBConfig): ItemViewModel<DBConfig>(dbConfig){

    val dbServer = bind(DBConfig::dbServerProperty)

}