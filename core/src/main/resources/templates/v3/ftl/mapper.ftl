<?xml version="1.0" encoding="UTF-8"?>
<!-- ${tableComment}(${tableName}) - ${className}.xml -->
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD templates.v3.kts.Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.mapper.${className}templates.v3.kts.Mapper">
    <resultMap id="baseMap" type="${basePackage}.model.dto.${className}">
<#if fieldInfos??>
    <#list fieldInfos as fieldInfo>
        <#if fieldInfo.field == "id">
        <id column="id" property = "id" javaType="java.lang.String"/>
        <#else>
        <result column="${fieldInfo.columnName}" property = "${fieldInfo.field}"/>
        </#if>
    </#list>
</#if>
    </resultMap>

    <sql id = "allColumn">
        <#list fieldInfos as fieldInfo>${fieldInfo.columnName}<#if fieldInfo?has_next>,</#if></#list>
    </sql>

    <insert id = "selOne" resultMap="baseMap" parameterType="java.lang.String">
        select <include refid = "allColumn"/> from ${tableName} where id = ${"#"}{id} and is_deleted = 0
    </insert>

    <select id="selAll" resultMap="baseMap">
        select <include refid = "allColumn"/> from ${tableName} tb
        <where>
            <#list fieldInfos as fieldInfo>
            <if test = "${fieldInfo.field} != null">
                and tb.${fieldInfo.columnName} = ${"#"}{${fieldInfo.field}}
            </if>
            </#list>
        </where>
        order by tb.create_time desc
    </select>

</mapper>