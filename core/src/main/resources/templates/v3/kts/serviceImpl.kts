import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment
val smallClassName = classInfo.smallClassName

"""
package ${basePackage}.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${basePackage}.service.${className}Service;
import ${basePackage}.mapper.${className}Mapper;
import ${basePackage}.model.entity.${className}DO;
import ${basePackage}.model.dto.${className}ResDTO;
import ${basePackage}.model.query.${className}Query;

import java.util.List;

/**
 * ${tableComment}
 */
@Service
@RequiredArgsConstructor
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}DO> implements ${className}Service{
    /**
     * ${tableComment}
     */
    private final ${className}Mapper ${smallClassName}Mapper;

    /**
     * 添加
     */
    @Override
    public String add(${className}DO param){
        ${smallClassName}Mapper.insert(param);
        return param.getId();
    }

    /**
     * 删除
     */
    @Override
    public void del(String id){
        ${smallClassName}Mapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public void upd(${className}DO param){
        ${smallClassName}Mapper.updateById(param);
    }

    /**
     * 查询详情
     */
    @Override
    public ${className}ResDTO selOne(String id){
        return ${smallClassName}Mapper.selOne(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<${className}ResDTO> selAll(${className}Query param){
        return ${smallClassName}Mapper.selAll(param);
    }
}
""".trimIndent()
