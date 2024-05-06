import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val field = StringBuilder()

classInfo.fieldInfos.forEach {
    field.appendLine("    /**")
        .appendLine("     * ${it.columnComment}")
        .appendLine("     */")
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
import com.aodun.lh.model.query.BasePageQuery;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * ${classInfo.tableComment}
 */
@Data
@Schema
public class ${classInfo.className}Query extends BasePageQuery{

$field

}
""".trimIndent()
