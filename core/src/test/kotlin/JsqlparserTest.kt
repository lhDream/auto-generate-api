import net.sf.jsqlparser.parser.CCJSqlParser
import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.create.table.CreateTable
import net.sf.jsqlparser.statement.select.*
import net.sf.jsqlparser.statement.values.ValuesStatement
import java.io.File
import javax.script.ScriptEngineManager

fun main(args: Array<String>) {

    val kts = ScriptEngineManager().getEngineByExtension("kts")
    kts.eval(File("d://testFile/test.kts").reader())
}