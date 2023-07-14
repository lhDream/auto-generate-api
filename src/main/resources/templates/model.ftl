package ${basePackage}.model

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
@TableName("${tableName}")
public class ${bigHumpTableName}DO {

<#if columnInfos??>
    <#list columnInfos as columnInfo>
    /**
     * ${columnInfo.columnComment}
     */
    @ApiModelProperty(value = "${columnInfo.columnComment}")
        <#if columnInfo.columnName == "id">
    @TableId(type = IdType.ASSIGN_UUID)
        </#if>
        <#if columnInfo.dataType == "int">
    private Integer ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "bigint">
    private Long ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "varchar">
    private String ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "double">
    private Double ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "flout">
    private Flout ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "date">
    private LocalDateTime ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "timestamp">
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ${columnInfo.columnName};
        </#if>
        <#if columnInfo.dataType == "tinyint">
    private Boolean ${columnInfo.columnName};
        </#if>
    </#list>
</#if>

}