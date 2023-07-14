package com.lhdream.model

/**
 * 表信息
 */
data class TableInfo(
    /**
     * 数据库表名
     */
    val tableName: String,
    /**
     * 表描述内容，表注释
     */
    val tableComment: String,
    /**
     * 大驼峰表名
     */
    val bigHumpTableName: String,
    /**
     * 小驼峰表名
     */
    val smallHumpTableName: String,

){
    var basePackage: String = ""
    var columnInfos: List<ColumnInfo>? = null
}