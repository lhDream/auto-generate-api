package com.lhdream.controller

import cn.hutool.core.util.StrUtil
import cn.hutool.extra.cglib.CglibUtil
import com.lhdream.model.ClassInfo
import com.lhdream.model.FieldInfo
import com.lhdream.util.CodeUtil
import com.lhdream.util.DBUtil
import tornadofx.*
import java.util.stream.Collectors
import kotlin.streams.toList

/**
 * 主界面业务实现
 */
class MainController: Controller() {
    /**
     * 确认，根据模板生成文件
     */
    fun enter(ip:String,port:String,username:String,password:String,dbName:String,groupId:String,tablePrefix:String,savePath:String){
        val tableInfos = DBUtil.getTableInfos(ip, port, username, password, dbName, tablePrefix)
        if(tableInfos.isEmpty()){
            throw RuntimeException("获取表数量为 0")
        }
        val classInfos = tableInfos.stream().map { tableInfo ->
            val fieldInfos = tableInfo.columnInfos.stream().map { columnInfo ->
                FieldInfo(
                    tableCatalog = columnInfo.tableCatalog,
                    tableSchema = columnInfo.tableSchema,
                    columnName = columnInfo.columnName,
                    field = StrUtil.toCamelCase(columnInfo.columnName),
                    ordinalPosition = columnInfo.ordinalPosition,
                    columnDefault = columnInfo.columnDefault,
                    isNullable = columnInfo.isNullable,
                    dataType = columnInfo.dataType,
                    columnComment = columnInfo.columnComment
                )
            }.collect(Collectors.toList())
            ClassInfo(
                tableName = tableInfo.tableName,
                tableComment = tableInfo.tableComment,
                bigHumpTableName = tableInfo.bigHumpTableName,
                smallHumpTableName = tableInfo.smallHumpTableName,
                smallClassName = tableInfo.smallClassName,
                className = tableInfo.className,
                fieldInfos = fieldInfos
            )
        }.collect(Collectors.toList())
        CodeUtil.createCode(classInfos,groupId, savePath)
    }

}