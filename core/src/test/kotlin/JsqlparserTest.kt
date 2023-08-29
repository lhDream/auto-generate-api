import net.sf.jsqlparser.parser.CCJSqlParser
import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.create.table.CreateTable
import net.sf.jsqlparser.statement.select.*
import net.sf.jsqlparser.statement.values.ValuesStatement

fun main(args: Array<String>) {
    val sql = "create table table_name(id int,name varchar(255))"

    val parse = CCJSqlParserUtil.parse(sql) as CreateTable
    parse.columnDefinitions
    println(parse.columnDefinitions)
    parse.columnDefinitions.forEach {
        println("name: ${it.columnName},type: ${it.colDataType}, ${it.columnSpecs}")
    }
//    println(parse.selectBody)
//
//    parse.selectBody.accept(object : PlainSelect(), SelectVisitor {
//        override fun visit(aThis: ValuesStatement?) {
//
//        }
//
//        override fun visit(plainSelect: PlainSelect) {
//            println(plainSelect.selectItems)
//        }
//
//        override fun visit(setOpList: SetOperationList?) {
//
//        }
//
//        override fun visit(withItem: WithItem?) {
//
//        }
//    })

}