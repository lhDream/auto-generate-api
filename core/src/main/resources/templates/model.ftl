package ${basePackage}.model

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ${tableComment}
 */
@Data
@ApiModel
@TableName("${tableName}")
public class ${className}DO {

<#if fieldInfos??>
    <#list fieldInfos as fieldInfo>
    /**
     * ${fieldInfo.columnComment}
     */
    @ApiModelProperty(value = "${fieldInfo.columnComment}")
        <#if fieldInfo.field == "id">
    @TableId
        </#if>
        <#if fieldInfo.fieldType == "LocalDateTime">
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        </#if>
    private ${fieldInfo.fieldType} ${fieldInfo.field};
    </#list>
</#if>

}