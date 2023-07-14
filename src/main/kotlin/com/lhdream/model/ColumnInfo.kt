package com.lhdream.model

data class ColumnInfo(
    val tableCatalog: Any?,
    /**
     * 数据库名称
     */
    val tableSchema: String,
    /**
     * 列名、字段名
     */
    val columnName: String,
    /**
     * 序号位置
     */
    val ordinalPosition: Any?,
    /**
     * 列默认值
     */
    val columnDefault: Any?,
    /**
     * 是否可为null
     */
    val isNullable: Any?,
    /**
     * 数据类型
     */
    val dataType: String,
    /**
     * 字段注释
     */
    val columnComment: String?

)
