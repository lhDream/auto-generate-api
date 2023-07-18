package com.lhdream.util

import cn.hutool.core.util.StrUtil
import cn.hutool.extra.template.Template
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateUtil
import cn.hutool.json.JSONUtil
import com.lhdream.model.ColumnInfo
import com.lhdream.model.TableInfo
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.support.mysql.MySqlDialect
import java.io.File
import kotlin.reflect.KParameter
import kotlin.reflect.full.valueParameters

object TestUtil {

    fun test(ip:String,port:String,username:String,password:String,dbName:String,groupId:String,tablePrefix:String,savePath:String){
        val database = Database.connect(
            url = "jdbc:mysql://$ip:$port",
            driver = "com.mysql.cj.jdbc.Driver",
            user = username,
            password = password,
            dialect = MySqlDialect()
        )

        val databaseName = dbName
        val tablePrefix = tablePrefix

        val tableInfos = database.useConnection { con ->
            val sql = "select table_name,table_comment from information_schema.tables where table_schema = ?"
            con.prepareStatement(sql).use { pre ->
                pre.setString(1,databaseName)
                pre.executeQuery().asIterable().map {
                    val tableName = it.getString(1)
                    val tableComment = it.getString(2)
                    val smallHumpTableName = StrUtil.toCamelCase(tableName)
                    val bigHumpTableName = StrUtil.upperFirst(smallHumpTableName)
                    val smallClassName = StrUtil.lowerFirst(StrUtil.toCamelCase(tableName.substring(tablePrefix.length)))
                    val className = StrUtil.upperFirst(smallClassName)
                    return@map TableInfo(tableName,tableComment,bigHumpTableName,smallHumpTableName,smallClassName,className)
                }
            }
        }
        tableInfos.forEach { tableInfo ->
            database.useConnection { con ->
                val sql = "select * from information_schema.columns where table_name = ? and table_schema = ?"
                val columnInfos = con.prepareStatement(sql).use { pre ->
                    pre.setString(1,tableInfo.tableName)
                    pre.setString(2,databaseName)
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
                tableInfo.columnInfos = columnInfos
            }
        }

        val templateConfig = TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH)

        val templates = arrayOf("controller","dao","mapper","model","service","serviceImpl")
        val templatesSuffix = arrayOf("java","java","xml","java","java","java")
        val classFileName = arrayOf("Controller","Mapper","Mapper","DO","Service","ServiceImpl")
        tableInfos.forEach { tableInfo ->
            tableInfo.basePackage = groupId
            for (i in templates.indices){
                val templateName = templates[i]
                val engine = TemplateUtil.createEngine(templateConfig)
                val template: Template = engine.getTemplate("$templateName.ftl")
                val result: String = template.render(JSONUtil.parseObj(tableInfo))
                val fileName = StrUtil.upperFirst(StrUtil.toCamelCase(tableInfo.tableName.substring(tablePrefix.length)))
                val file = File(savePath  + "/" + tableInfo.basePackage.replace(".", "/") + "/$templateName/$fileName${classFileName[i]}.${templatesSuffix[i]}")
                if(!file.parentFile.exists()){
                    file.parentFile.mkdirs()
                }
                file.writeText(result)
            }
        }
    }

}