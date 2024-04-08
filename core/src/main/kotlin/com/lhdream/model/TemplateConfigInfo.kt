package com.lhdream.model

data class TemplateConfigInfo(
    /**
     * 模板名称
     */
    val templateName: String,
){
    /**
     * 模板保存路径
     */
    val templatePath: String = "templates/v3"
}
