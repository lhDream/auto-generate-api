package ${basePackage}.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${basePackage}.service.${className}Service;
import ${basePackage}.mapper.${className}Mapper;
import ${basePackage}.model.entity.${className}DO;

/**
 * ${tableComment}
 */
@Service
@RequiredArgsConstructor
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}DO> implements ${className}Service{

    private final ${className}Mapper ${smallClassName}Mapper;

}