import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment

"""
package ${basePackage}.mapper;

import org.apache.ibatis.annotations.templates.v3.kts.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basePackage}.model.entity.${className}DO;

/**
 * ${tableComment}
 */
@templates.v3.kts.Mapper
public interface ${className}templates.v3.kts.Mapper extends BaseMapper<${className}DO>{

}
""".trimIndent()
