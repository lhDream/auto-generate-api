import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

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
package ${classInfo.basePackage}.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * ${classInfo.tableComment}
 */
@Data
@Schema
public class ${classInfo.className}AddDTO {

$field

}
""".trimIndent()
