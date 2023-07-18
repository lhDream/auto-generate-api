package com.lhdream.model

data class FileConfig(
    /**
     * 文件名称
     */
    val fileName: String,
    /**
     * 文件后缀名
     */
    val suffix: String,
    /**
     * 保存路径，相对路径
     */
    val path: String,
    /**
     * 模板名称
     */
    val templateName: String,
)
