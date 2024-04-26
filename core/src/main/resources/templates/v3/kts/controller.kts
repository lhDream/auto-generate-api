import com.lhdream.model.ClassInfo

val classInfo = bindings["data"] as ClassInfo

"""
package ${classInfo.basePackage}.controller;

import com.aodun.caution.model.dto.IdDto;
import com.aodun.common.commonEntityMg.entity.CommonEntity;
import com.aodun.common.resultMg.CustomizeResult;
import ${classInfo.basePackage}.service.${classInfo.className}Service;
import ${classInfo.basePackage}.model.entity.${classInfo.className}DO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "${classInfo.tableComment}", description = "${classInfo.tableComment}")
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
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${classInfo.className}DO> param){
        return CustomizeResult.success(${classInfo.smallClassName}Service.add(param.getData()));
    }

    /**
    * 删除
    */
    @PostMapping("/del")
    @Operation(summary = "删除")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        ${classInfo.smallClassName}Service.del(param.getData().getId());
        return CustomizeResult.success();
    }

    /**
    * 修改
    */
    @PostMapping("/upd")
    @Operation(summary = "修改")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${classInfo.className}DO> param){
        ${classInfo.smallClassName}Service.upd(param.getData());
        return CustomizeResult.success();
    }

    /**
    * 查询详情
    */
    @PostMapping("/selOne")
    @Operation(summary = "查询详情")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${classInfo.smallClassName}Service.selOne(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @PostMapping("/selAll")
    @Operation(summary = "查询列表")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${classInfo.className}DO> param){
        return CustomizeResult.success(${classInfo.smallClassName}Service.selAll(param.getData()));
    }

}
""".trimIndent()
