package ${basePackage}.service.impl

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${basePackage}.service.${bigHumpTableName}Service;
import ${basePackage}.mapper.${bigHumpTableName}Mapper;
import ${basePackage}.model.${bigHumpTableName}DO;

/**
 * ${tableComment}
 */
@Service
@RequiredArgsConstructor
public class ${bigHumpTableName}ServiceImpl extends ServiceImpl<${bigHumpTableName}Mapper, ${bigHumpTableName}DO> implements ${bigHumpTableName}Service{

    private final ${bigHumpTableName}Mapper ${smallHumpTableName}Mapper;

}