import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment
val tableName = classInfo.tableName

val field = StringBuilder()

classInfo.fieldInfos.forEach {
    field.appendLine("    /*")
        .appendLine("     * ${it.columnComment}")
        .appendLine("     */")
    if (it.field == "id"){
        field.appendLine("    @TableId")
    }
    if (it.field == "isDeleted"){
        field.appendLine("    @TableLogic")
    }
    field.appendLine("    @Schema(description = \"${it.columnComment}\")")
    if (it.fieldType == "LocalDateTime"){
        field.appendLine("    @JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")")
        field.appendLine("    @DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")")
    }
    field.appendLine("    private ${it.fieldType} ${it.field};")
}

"""
package ${basePackage}.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ${tableComment}
 */
@Data
@Schema
@TableName("${tableName}")
public class ${className}DO {

$field

}
""".trimIndent()
