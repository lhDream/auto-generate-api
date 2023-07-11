import cn.hutool.core.lang.Dict
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateConfig.ResourceMode
import cn.hutool.extra.template.TemplateUtil
import cn.hutool.json.JSONUtil
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.support.mysql.MySqlDialect


fun main(args: Array<String>) {
    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "aodun@2012",
        dialect = MySqlDialect()
    )

    val databaseName = "dg_fire"

    val tableNames = database.useConnection { con ->
        val sql = "select table_name from information_schema.tables where table_schema = ?"
        con.prepareStatement(sql).use { pre ->
            pre.setString(1,databaseName)
            pre.executeQuery().asIterable().map { it.getString(1) }
        }
    }
    val engine = TemplateUtil.createEngine(TemplateConfig("templates", ResourceMode.CLASSPATH))
    val format = engine.getTemplate("test.ftl").render(Dict.create().set("tableNames",tableNames))
    println(format)
    tableNames.forEach {
        println("---------------tableName: $it ----------------")


        val tableName = "$databaseName.$it"

        database.useConnection { con ->
            val sql = "describe $tableName"
            val tableInfos = con.prepareStatement(sql).use { pre ->
                pre.executeQuery().asIterable().map { res ->
                    TableInfo(
                        res.getString("field"),
                        res.getString("type"),
                        res.getString("null"),
                        res.getString("key"),
                        if(res.getObject("default") == null) "" else res.getObject("default").toString(),
                        res.getString("extra")
                    )
                }
            }
            for (tableInfo in tableInfos) {
                val engine = TemplateUtil.createEngine(TemplateConfig("templates", ResourceMode.CLASSPATH))
                val format = engine.getTemplate("test.ftl").render(JSONUtil.parseObj(tableInfo))
                println(format)
//                println("field: ${tableInfo.field} type: ${tableInfo.type} null: ${tableInfo.isNull} key: ${tableInfo.key} default: ${tableInfo.default} extra: ${tableInfo.extra}")
            }
        }


    }

}

class TableInfo(
    val field: String,
    val type: String,
    val isNull: String,
    val key: String,
    val default: String,
    val extra: String,
)