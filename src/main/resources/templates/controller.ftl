package ${basePackage}.controller

import com.aodun.common.commonEntityMg.entity.CommonEntity;
import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * ${tableComment}
 */
@RestController
@RequiredArgsConstructor
@Api(value = "${tableComment}", tags = {"${tableComment}"})
@RequestMapping("/${smallClassName}")
public class ${className}Controller {
    /*
     * ${tableComment}
     */
    private final ${className}Service ${smallClassName}Service;

    /**
     * 添加
     */
    @ApiOperation(value = "添加")
    @PostMapping("/add")
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${smallClassName}DO> param){
        return CustomizeResult.success(${smallClassName}Service.add(param.getData()));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除")
    @PostMapping("/del")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallClassName}Service.removeById(param.getData().getId()));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "修改")
    @PostMapping("/upd")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(${smallClassName}Service.add(param.getData()));
    }

    /**
    * 查询详情
    */
    @ApiOperation(value = "查询详情")
    @PostMapping("/selOne")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallClassName}Service.getById(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @ApiOperation(value = "查询列表")
    @PostMapping("/selAll")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${className}DO> param){
        return CustomizeResult.success(tbTaskTypeInfoService.list(new QueryWrapper<>(param.getData())));
    }

}