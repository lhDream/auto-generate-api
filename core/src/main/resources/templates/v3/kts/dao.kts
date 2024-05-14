import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment

"""
package ${basePackage}.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basePackage}.model.entity.${className}DO;
import ${classInfo.basePackage}.model.dto.${classInfo.className}ResDTO;
import ${classInfo.basePackage}.model.query.${classInfo.className}Query;

/**
 * ${tableComment}
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}DO>{

    ${className}ResDTO selOne(String id);

    List<${className}ResDTO> selAll(${className}Query param);

}
""".trimIndent()
