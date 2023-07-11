
<#--field: ${field?if_exists} type: ${type?if_exists} null: ${isNull?if_exists} key: ${key?if_exists} default: ${default?if_exists} extra: ${extra?if_exists}-->
<#--tableNames: <#list tableNames as tableName>${tableName}<#if tableName_has_next>,</#if></#list>-->
<#if tableNames??>
    tableNames: <#list tableNames as tableName>${tableName}<#if tableName_has_next>,</#if></#list>
</#if>
