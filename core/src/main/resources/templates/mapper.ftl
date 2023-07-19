<?xml version="1.0" encoding="UTF-8"?>
<!-- ${className}.xml -->
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackage}.dao.${className}">

    <resultMap id="baseResultMap" type="${basePackage}.model.${className}DO">
<#list columnInfos as columnInfo>
        <result column="${columnInfo.}" property="${columnInfo.columnName}"/>
</#list>
    </resultMap>

</mapper>