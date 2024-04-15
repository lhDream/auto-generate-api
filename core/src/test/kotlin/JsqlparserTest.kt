import net.sf.jsqlparser.parser.CCJSqlParser
import net.sf.jsqlparser.parser.CCJSqlParserUtil
import net.sf.jsqlparser.statement.create.table.CreateTable
import net.sf.jsqlparser.statement.select.*
import net.sf.jsqlparser.statement.values.ValuesStatement
import java.io.File
import javax.script.Bindings
import javax.script.ScriptEngineManager
import javax.script.SimpleBindings

fun main(args: Array<String>) {

    val engine = ScriptEngineManager().getEngineByExtension("kts")

    engine.put("test","lhDream")
    val res = engine.eval(File("d://testFile/test.kts").reader())
    println(res)
}