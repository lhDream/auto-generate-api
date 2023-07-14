import cn.hutool.core.util.StrUtil
import cn.hutool.extra.template.Template
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateConfig.ResourceMode
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


fun main(args: Array<String>) {
    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "aodun@2012",
        dialect = MySqlDialect()
    )

    val databaseName = "manage_sys"
    val tablePrefix = "tb_manage"

    val tableInfos = database.useConnection { con ->
        val sql = "select table_name,table_comment from information_schema.tables where table_schema = ?"
        con.prepareStatement(sql).use { pre ->
            pre.setString(1,databaseName)
            pre.executeQuery().asIterable().map {
                val tableName = it.getString(1)
                val tableComment = it.getString(2)
                val smallHumpTableName = StrUtil.toCamelCase(tableName)
                val bigHumpTableName = StrUtil.upperFirst(smallHumpTableName)
                return@map TableInfo(tableName,tableComment,bigHumpTableName,smallHumpTableName)
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

    val templateConfig = TemplateConfig("templates", ResourceMode.CLASSPATH)

    val pack = "com.aodun"
    val templates = arrayOf("controller","dao","mapper","model","service","serviceImpl")
    val templatesSuffix = arrayOf("java","java","xml","java","java","java")
    val classFileName = arrayOf("Controller","Mapper","Mapper","DO","Service","ServiceImpl")
    tableInfos.forEach { tableInfo ->
        tableInfo.basePackage = pack
        for (i in templates.indices){
            val templateName = templates[i]
            val engine = TemplateUtil.createEngine(templateConfig)
            val template: Template = engine.getTemplate("$templateName.ftl")
            val result: String = template.render(JSONUtil.parseObj(tableInfo))
            val fileName = StrUtil.upperFirst(StrUtil.toCamelCase(tableInfo.tableName.substring(tablePrefix.length)))
            val file = File("D://testFile/test/" + tableInfo.basePackage.replace(".", "/") + "/$templateName/$fileName${classFileName[i]}.${templatesSuffix[i]}")
            if(!file.parentFile.exists()){
                file.parentFile.mkdirs()
            }
            file.writeText(result)
        }
    }

}



