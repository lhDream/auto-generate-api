package com.lhdream.model

import com.lhdream.util.DBUtil

/**
 * 字段信息
 */
data class FieldInfo (
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
     * 属性名
     */
    val field: String,
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
    val isNullable: String,
    /**
     * 是否必填
     */
    val required: Boolean,
    /**
     * 数据类型
     */
    val dataType: String,
    /**
     * 字段注释
     */
    val columnComment: String?
){
    /**
     * 属性类型
     */
    val fieldType: String = DBUtil.getType(this.dataType)

    fun getIsNullable(): String {
        return this.isNullable
    }

}