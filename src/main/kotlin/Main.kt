import cn.hutool.core.lang.Dict
import cn.hutool.core.util.StrUtil
import cn.hutool.extra.template.TemplateConfig
import cn.hutool.extra.template.TemplateConfig.ResourceMode
import cn.hutool.extra.template.TemplateUtil
import cn.hutool.json.JSONUtil
import org.ktorm.database.Database
import org.ktorm.database.asIterable
import org.ktorm.support.mysql.MySqlDialect
import kotlin.reflect.KParameter
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.full.valueParameters


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
    val tableInfos = arrayListOf<TableInfo>()
    tableNames.forEach {
        val tableName = "$databaseName.$it"

        println("---------------tableName: $tableName ----------------")
        val tableInfo = TableInfo(it)


        database.useConnection { con ->
            val sql = "select * from information_schema.columns where table_name = ? and table_schema = ?"
            val columnInfos = con.prepareStatement(sql).use { pre ->
                pre.setString(1,it)
                pre.setString(2,databaseName)
                pre.executeQuery().asIterable().map { res ->
                    val tableInfoValueParams = ::ColumnInfo.valueParameters
                    val argsMap = HashMap<KParameter,Any>()
                    tableInfoValueParams.elementAt(0).type
                    for (tableInfoValueParam in tableInfoValueParams) {
                        val value = res.getObject(StrUtil.toUnderlineCase(tableInfoValueParam.name))
                        argsMap[tableInfoValueParam] = value

                    }
                    ::ColumnInfo.callBy(argsMap)
                }

            }
            tableInfo.columnInfos = columnInfos
        }

        tableInfos.add(tableInfo)
    }

}

data class TableInfo(
    val tableName: String
){
    var columnInfos: List<ColumnInfo>? = null
}

data class ColumnInfo(
    val tableCatalog: String,
    /**
     * 数据库名称
     */
    val tableSchema: String,
    /**
     * 列名、字段名
     */
    val columnName: String,
    /**
     * 序号位置
     */
    val ordinalPosition: Any,
    /**
     * 列默认值
     */
    val columnDefault: Any,
    /**
     * 是否可为null
     */
    val isNullable: Any,
    /**
     * 数据类型
     */
    val dataType: Any,

)