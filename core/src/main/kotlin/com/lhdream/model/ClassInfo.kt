package com.lhdream.model

/**
 * 类信息
 */
data class ClassInfo(
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
     * 属性列表
     */
    val fieldInfos: List<FieldInfo>

) {
    /**
     * 包名
     */
    var basePackage: String = ""
}