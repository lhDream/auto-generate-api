import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo


val resultMap = StringBuilder()
val sql = StringBuilder()
val selAll = StringBuilder()

classInfo.fieldInfos.forEach {
    resultMap.append("                <result column=\"${it.columnName}\" property = \"${it.field}\"/> \n")
    sql.append(it.field).append(",")
    selAll.append("                <if test = \"${it.field} != null\">\n")
    selAll.append("                    and tb.${it.columnName} = #{${it.field}}\n")
    selAll.append("                </if>\n")
}

resultMap.setLength(resultMap.length - 1)
sql.setLength(sql.length - 1)
selAll.setLength(selAll.length - 1)



val res = """
    <?xml version="1.0" encoding="UTF-8"?>
    <!-- ${classInfo.tableComment}(${classInfo.tableName}) - ${classInfo.className}.xml -->
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="${classInfo.basePackage}.mapper.${classInfo.className}Mapper">
        <resultMap id = "baseMap" type = "${classInfo.basePackage}.model.dto.${classInfo.className}DTO">
${resultMap.toString()}
        </resultMap>
        
        <sql id = "allColumn">
            ${sql}
        </sql>
        
        <insert id = "selOne" parameterType="java.lang.String">
            select <include refid = "allColumn"/> from ${classInfo.tableName} where id = #{id} and is_deleted = 0
        </insert>
        
        <select id="selAll" resultMap="baseMap">
            select <include refid = "allColumn"/> from ${classInfo.tableName} tb
            <where>
${selAll}
            </where>
            order by tb.create_time desc
        </select>
    </mapper>
""".trimIndent()

res