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
    /**
     * 小驼峰类名
     */
    val smallClassName: String,
    /**
     * 类名
     */
    val className: String,
    /**
     * 字段信息列表
     */
    val columnInfos: List<ColumnInfo>
){
    var basePackage: String = ""
}