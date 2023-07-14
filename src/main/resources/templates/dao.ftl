package ${basePackage}.mapper

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${basePackage}.model.${bigHumpTableName}DO

/**
 * ${tableComment}
 */
@Mapper
public interface ${bigHumpTableName}Mapper extends BaseMapper<${bigHumpTableName}DO>{

}