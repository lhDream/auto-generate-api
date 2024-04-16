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
import ${basePackage}.mapper.${className}templates.v3.kts.Mapper;
import ${basePackage}.model.entity.${className}DO;

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
    private final ${className}templates.v3.kts.Mapper ${smallClassName}templates.v3.kts.Mapper;

    /**
     * 添加
     */
    @Override
    public String add(${className}DO param){
        ${smallClassName}templates.v3.kts.Mapper.insert(param);
        return param.getId();
    }

    /**
     * 删除
     */
    @Override
    public void del(String id){
        ${smallClassName}templates.v3.kts.Mapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public void upd(${className}DO param){
        ${smallClassName}templates.v3.kts.Mapper.updateById(param);
    }

    /**
     * 查询详情
     */
    @Override
    public ${className}DO selOne(String id){
        return ${smallClassName}templates.v3.kts.Mapper.selectById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<${className}DO> selAll(${className}DO param){
        return ${smallClassName}templates.v3.kts.Mapper.selectList(new QueryWrapper<>(param));
    }
}
""".trimIndent()
