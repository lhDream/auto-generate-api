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
import ${classInfo.basePackage}.model.entity.dto.${classInfo.className}ResDTO;
import ${classInfo.basePackage}.model.entity.query.${classInfo.className}Query;

/**
 * ${tableComment}
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}DO>{

}
""".trimIndent()
