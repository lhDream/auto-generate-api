package ${basePackage}.mapper

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basePackage}.model.${className}DO

/**
 * ${tableComment}
 */
@Mapper
public interface ${className}Mapper extends BaseMapper<${className}DO>{

}