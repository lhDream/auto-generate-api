package com.lhdream.util

import cn.hutool.core.util.StrUtil
import com.lhdream.model.ColumnInfo
import com.lhdream.model.TableInfo
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.support.mysql.MySqlDialect
import kotlin.reflect.KParameter
import kotlin.reflect.full.valueParameters

object DBUtil {

    val dbType: HashMap<String,String> = hashMapOf()

    init {
        // 数值
        dbType["tinyint"] = "Boolean"
        dbType["smallint"] = "Short"
        dbType["mediumint"] = "Integer"
        dbType["int"] = "Integer"
        dbType["integer"] = "Integer"
        dbType["bigint"] = "Long"
        dbType["float"] = "Float"
        dbType["double"] = "Double"
        // 日期
        dbType["decimal"] = "BigDecimal"
        dbType["date"] = "LocalDateTime"
        dbType["time"] = "LocalDateTime"
        dbType["datetime"] = "LocalDateTime"
        dbType["timestamp"] = "LocalDateTime"
        // 字符串
        dbType["char"] = "String"
        dbType["varchar"] = "String"
        dbType["tinyblob"] = "String"
        dbType["tinytext"] = "String"
        dbType["blob"] = "String"
        dbType["text"] = "String"
        dbType["mediumblob"] = "String"
        dbType["mediumtext"] = "String"
        dbType["longblob"] = "String"
        dbType["longtext"] = "String"
    }

    fun getTableInfos(ip:String,port:String,username:String,password:String,dbName:String,tablePrefix:String): List<TableInfo> {
        val database = Database.connect(
            url = "jdbc:mysql://$ip:$port",
            driver = "com.mysql.cj.jdbc.Driver",
            user = username,
            password = password,
            dialect = MySqlDialect()
        )
        // 获取表信息
        val tableInfos = database.useConnection { con ->
            val sql = "select table_name,table_comment from information_schema.tables where table_schema = ?"
            con.prepareStatement(sql).use { pre ->
                pre.setString(1,dbName)
                pre.executeQuery().asIterable().map {
                    val tableName = it.getString(1)
                    val tableComment = it.getString(2)
                    val smallHumpTableName = StrUtil.toCamelCase(tableName)
                    val bigHumpTableName = StrUtil.upperFirst(smallHumpTableName)
                    val smallClassName = StrUtil.lowerFirst(StrUtil.toCamelCase(tableName.substring(tablePrefix.length)))
                    val className = StrUtil.upperFirst(smallClassName)
                    // 获取表字段信息
                    val columnSql = "select * from information_schema.columns where table_name = ? and table_schema = ?"
                    val columnInfos = con.prepareStatement(columnSql).use { pre ->
                        pre.setString(1,tableName)
                        pre.setString(2,dbName)
                        pre.executeQuery().asIterable().map { res ->
                            val columnInfoValueParams = ::ColumnInfo.valueParameters
                            val argsMap = HashMap<KParameter,Any?>()
                            for (tableInfoValueParam in columnInfoValueParams) {
                                val value = res.getObject(StrUtil.toUnderlineCase(tableInfoValueParam.name))
                                argsMap[tableInfoValueParam] = value
                            }
                            ::ColumnInfo.callBy(argsMap)
                        }
                    }
                    return@map TableInfo(tableName,tableComment,bigHumpTableName,smallHumpTableName,smallClassName,className,columnInfos)
                }
            }
        }
        return tableInfos
    }

    fun getType(type:String):String{
        return dbType[type]?: "String"
    }

}