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

<#if fieldInfos??>
    <#list fieldInfos as fieldInfo>
    /**
     * ${fieldInfo.columnComment}
     */
        <#if fieldInfo.field == "id">
    @TableId(type = IdType.ASSIGN_ID)
        </#if>
        <#if fieldInfo.field == "isDeleted">
    @TableLogic
        </#if>
    @Schema(description = "${fieldInfo.columnComment}")
        <#if fieldInfo.field == "createTime" || fieldInfo.field = "creator">
    @TableField(fill = FieldFill.INSERT)
        </#if>
        <#if fieldInfo.field == "updateTime" || fieldInfo.field = "updater">
    @TableField(fill = FieldFill.INSERT_UPDATE)
        </#if>
        <#if fieldInfo.fieldType == "LocalDateTime">
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        </#if>
    private ${fieldInfo.fieldType} ${fieldInfo.field};
    </#list>
</#if>

}