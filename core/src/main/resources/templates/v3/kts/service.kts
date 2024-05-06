import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment

"""
package ${basePackage}.service;

import ${basePackage}.model.entity.${className}DO;
import ${classInfo.basePackage}.model.entity.dto.${classInfo.className}ResDTO;
import ${classInfo.basePackage}.model.entity.query.${classInfo.className}Query;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ${tableComment}
 */
public interface ${className}Service extends IService<${className}DO>{

    /**
     * 添加
     */
    String add(${className}DO param);

    /**
     * 删除
     */
    void del(String id);

    /**
     * 修改
     */
    void upd(${className}DO param);

    /**
     * 查询详情
     */
    ${className}ResDTO selOne(String id);

    /**
     * 查询列表
     */
    List<${className}ResDTO> selAll(${className}Query param);
}
""".trimIndent()
