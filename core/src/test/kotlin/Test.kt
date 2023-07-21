import cn.hutool.core.util.IdUtil
import cn.hutool.core.util.ReUtil
import com.lhdream.model.ColumnInfo
import com.lhdream.model.TableInfo
import com.lhdream.util.DBUtil
import java.util.stream.Collectors
import kotlin.streams.toList

class Test {

}


fun main(){
    val oldTableInfos = DBUtil.getTableInfos("localhost","3306","root","aodun@2012","fire_test","")

    val oldTableNames = oldTableInfos.stream().collect(Collectors.groupingBy(TableInfo::tableName))


    val newTableInfos = DBUtil.getTableInfos("192.168.8.124","10086","root","Aodun@2020_2022","prevention_fire_v2","")
    newTableInfos.forEach { tableInfo ->
        val oldTableInfo = oldTableNames[tableInfo.tableName]
        if(oldTableInfo == null){
            println(tableInfo.tableName)
        }
        var str = ""

        tableInfo.columnInfos.forEach { new ->
            var flag = true
            oldTableInfo!![0]!!.columnInfos.forEach { old ->
                if(old.columnName == new .columnName){
                    flag = false
                }
            }
            if(flag){
                str += "${new.columnName}:${new.dataType} "
            }
        }

//        newColumnNames.forEach {
//            if(!oldColumnNames!!.contains(it)){
//                str += "$it: "
//            }
//        }
        if(str.isNotEmpty()){
            print("\ntableName: ${tableInfo.tableName} 缺少字段 $str")
        }
    }


}
