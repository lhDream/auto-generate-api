package ${basePackage}.mapper.${group}

import org.apache.ibatis.annotations.Mapper;
import ${basePackage}.model.${group}.${noPrefixTableName}DO

/**
 *
 */
@Mapper
public interface ${noPrefixTableName}Mapper extends BaseMapper<${noPrefixTableName}DO>{

}