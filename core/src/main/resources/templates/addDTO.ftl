package ${basePackage}.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * ${tableComment}
 */
@Data
@ApiModel
public class ${className}AddDTO {

<#if fieldInfos??>
    <#list fieldInfos as fieldInfo>
    /**
     * ${fieldInfo.columnComment}
     */
        <#if fieldInfo.field == "id">
    @TableId
        </#if>
        <#if fieldInfo.field == "isDeleted">
    @TableLogic
        </#if>
    @ApiModelProperty(value = "${fieldInfo.columnComment}")
        <#if fieldInfo.fieldType == "LocalDateTime">
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        </#if>
        <#if fieldInfo.required>
    @NotNull(message = "${fieldInfo.field}不能为null")
        </#if>
    private ${fieldInfo.fieldType} ${fieldInfo.field};
    </#list>
</#if>

}