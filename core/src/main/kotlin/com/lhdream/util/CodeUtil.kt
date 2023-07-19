package com.lhdream.util

import cn.hutool.extra.template.Template
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateUtil
import cn.hutool.json.JSONUtil
import com.lhdream.model.TableInfo
import java.io.File

/**
 * 代码生成工具类
 */
object CodeUtil {

    fun createCode(tableInfos: List<TableInfo>,groupId:String,savePath:String){
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
                val fileName = tableInfo.bigHumpTableName
                val file = File(savePath  + "/" + tableInfo.basePackage.replace(".", "/") + "/$templateName/$fileName${classFileName[i]}.${templatesSuffix[i]}")
                if(!file.parentFile.exists()){
                    file.parentFile.mkdirs()
                }
                file.writeText(result)
            }
        }
    }

}