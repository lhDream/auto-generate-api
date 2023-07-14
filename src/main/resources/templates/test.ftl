package ${basePackage}

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("${tableName}")
public class ${className}DO {

<#if fields??>
    <#list fields as field>
        <#if field.name == "id">

        </#if>

        private ${field.type} ${field.name};
    </#list>
</#if>

}