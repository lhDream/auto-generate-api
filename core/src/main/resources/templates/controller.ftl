package ${basePackage}.controller;

import com.aodun.common.commonEntityMg.entity.CommonEntity;
import com.aodun.common.resultMg.CustomizeResult;
import ${basePackage}.service.${className}Service;
import ${basePackage}.model.entity.${className}DO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "${tableComment}", tags = {"${tableComment}"})
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
    @ApiOperation(value = "添加")
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.save(param.getData()));
    }

    /**
    * 删除
    */
    @PostMapping("/del")
    @ApiOperation(value = "删除")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallClassName}Service.removeById(param.getData().getId()));
    }

    /**
    * 修改
    */
    @PostMapping("/upd")
    @ApiOperation(value = "修改")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.updateById(param.getData()));
    }

    /**
    * 查询详情
    */
    @PostMapping("/selOne")
    @ApiOperation(value = "查询详情")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallClassName}Service.getById(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @PostMapping("/selAll")
    @ApiOperation(value = "查询列表")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.list(new QueryWrapper<>(param.getData())));
    }

}