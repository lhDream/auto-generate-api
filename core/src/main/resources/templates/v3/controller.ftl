package ${basePackage}.controller;

import com.aodun.common.commonEntityMg.entity.CommonEntity;
import com.aodun.common.resultMg.CustomizeResult;
import ${basePackage}.service.${className}Service;
import ${basePackage}.model.entity.${className}DO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ${tableComment}
 */
@RestController
@RequiredArgsConstructor
@Schema(name = "${tableComment}", description = "${tableComment}")
@RequestMapping("/${smallClassName}")
public class ${className}Controller {
    /**
     * ${tableComment}
     */
    private final ${className}Service ${smallClassName}Service;

    /**
     * 添加
     */
    @PostMapping("/add")
    @Operation(summary = "添加")
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.add(param.getData()));
    }

    /**
    * 删除
    */
    @PostMapping("/del")
    @Operation(summary = "删除")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        ${smallClassName}Service.del(param.getData().getId());
        return CustomizeResult.success();
    }

    /**
    * 修改
    */
    @PostMapping("/upd")
    @Operation(summary = "修改")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${className}DO> param){
        ${smallClassName}Service.upd(param.getData());
        return CustomizeResult.success();
    }

    /**
    * 查询详情
    */
    @PostMapping("/selOne")
    @Operation(summary = "查询详情")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallClassName}Service.selOne(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @PostMapping("/selAll")
    @Operation(summary = "查询列表")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.selAll(param.getData()));
    }

}