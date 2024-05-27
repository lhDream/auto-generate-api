import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

"""
package ${classInfo.basePackage}.controller;

import cn.hutool.core.bean.BeanUtil;
import com.aodun.common.commonEntityMg.entity.CommonEntity;
import com.aodun.lh.factory.ResultFactory;
import ${classInfo.basePackage}.service.${classInfo.className}Service;
import ${classInfo.basePackage}.model.entity.${classInfo.className}DO;
import ${classInfo.basePackage}.model.dto.${classInfo.className}AddDTO;
import ${classInfo.basePackage}.model.dto.${classInfo.className}UpdDTO;
import ${classInfo.basePackage}.model.dto.${classInfo.className}ResDTO;
import ${classInfo.basePackage}.model.query.${classInfo.className}Query;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

/**
 * ${classInfo.tableComment}
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "${classInfo.tableComment}", description = "${classInfo.tableComment}")
@RequestMapping("/${classInfo.smallClassName}")
public class ${classInfo.className}Controller {
    /**
     * ${classInfo.tableComment}
     */
    private final ${classInfo.className}Service ${classInfo.smallClassName}Service;

    /**
     * 添加
     */
    @PostMapping("/add")
    @Operation(summary = "添加")
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${classInfo.className}AddDTO> param){
        var data = BeanUtil.copyProperties(param.getData(),${classInfo.className}DO.class);
        return ResultFactory.success(${classInfo.smallClassName}Service.add(data));
    }

    /**
    * 删除
    */
    @PostMapping("/del")
    @Operation(summary = "删除")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        ${classInfo.smallClassName}Service.del(param.getData().getId());
        return ResultFactory.success();
    }

    /**
    * 修改
    */
    @PostMapping("/upd")
    @Operation(summary = "修改")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${classInfo.className}UpdDTO> param){
        var data = BeanUtil.copyProperties(param.getData(),${classInfo.className}DO.class);
        ${classInfo.smallClassName}Service.upd(data);
        return ResultFactory.success();
    }

    /**
    * 查询详情
    */
    @PostMapping("/selOne")
    @Operation(summary = "查询详情")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return ResultFactory.success(${classInfo.smallClassName}Service.selOne(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @PostMapping("/selAll")
    @Operation(summary = "查询列表")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${classInfo.className}Query> param){
        var query = param.getData();
        query.startPage();
        return ResultFactory.success(${classInfo.smallClassName}Service.selAll(param.getData()));
    }

}
""".trimIndent()
