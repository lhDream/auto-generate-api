<?xml version="1.0" encoding="UTF-8"?>
<!-- ${tableComment}(${tableName}) - ${className}.xml -->
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.mapper.${className}Mapper">
    <resultMap id="baseMap" type="${basePackage}.model.dto.${className}">
<#if fieldInfos??>
    <#list fieldInfos as fieldInfo>
        <#if fieldInfo.field == "id">
        <id column="id" javaType="java.lang.String"/>
        <#else>
        <result column="${fieldInfo.field}" javaType="${fieldInfo.fieldType}"/>
        </#if>
    </#list>
</#if>
    </resultMap>
</mapper>