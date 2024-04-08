package com.lhdream.util

import cn.hutool.extra.template.Template
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateUtil
import com.alibaba.fastjson2.JSONObject
import com.lhdream.model.ClassInfo
import java.io.File

/**
 * 代码生成工具类
 */
object CodeUtil {

    fun createCode(classInfos: List<ClassInfo>,groupId:String,savePath:String){
        val templateConfig = TemplateConfig("templates/v3", TemplateConfig.ResourceMode.CLASSPATH)
        val templates = arrayOf("controller","dao","mapper","model","service","serviceImpl","addDTO")
        val templatesSuffix = arrayOf("java","java","xml","java","java","java","java")
        val classFileName = arrayOf("Controller","Mapper","Mapper","DO","Service","ServiceImpl","DTO")
        val path = arrayOf("controller","dao","mapper","model/entity","service","service/impl","model/dto")
        classInfos.forEach { classInfo ->
            classInfo.basePackage = groupId
            for (i in templates.indices){
                val templateName = templates[i]
                val engine = TemplateUtil.createEngine(templateConfig)
                val template: Template = engine.getTemplate("$templateName.ftl")

                val result: String = template.render(JSONObject.from(classInfo))
                val fileName = classInfo.className
                val file = File(savePath  + "/" + classInfo.basePackage.replace(".", "/") + "/${path[i]}/$fileName${classFileName[i]}.${templatesSuffix[i]}")
                if(!file.parentFile.exists()){
                    file.parentFile.mkdirs()
                }
                file.writeText(result)
            }
        }
    }

}