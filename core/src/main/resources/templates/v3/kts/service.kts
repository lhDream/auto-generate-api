import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

val basePackage = classInfo.basePackage
val className = classInfo.className
val tableComment = classInfo.tableComment

"""
package ${basePackage}.service;

import ${basePackage}.model.entity.${className}DO;
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
    ${className}DO selOne(String id);

    /**
     * 查询列表
     */
    List<${className}DO> selAll(${className}DO param);
}
""".trimIndent()
