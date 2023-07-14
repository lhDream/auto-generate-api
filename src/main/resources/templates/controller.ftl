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
@RequestMapping("/${smallHumpTableName}")
public class ${bigHumpTableName}Controller {
    /*
     * ${tableComment}
     */
    private final ${bigHumpTableName}Service ${smallHumpTableName}Service;

    /**
     * 添加
     */
    @ApiOperation(value = "添加")
    @PostMapping("/add")
    public CustomizeResult<?> add(@Valid @RequestBody CommonEntity<${bigHumpTableName}DO> param){
        return CustomizeResult.success(${smallHumpTableName}Service.add(param.getData()));
    }

    /**
    * 删除
    */
    @ApiOperation(value = "删除")
    @PostMapping("/del")
    public CustomizeResult<?> del(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallHumpTableName}Service.removeById(param.getData().getId()));
    }

    /**
    * 修改
    */
    @ApiOperation(value = "修改")
    @PostMapping("/upd")
    public CustomizeResult<?> upd(@Valid @RequestBody CommonEntity<${bigHumpTableName}DO> param){
        return CustomizeResult.success(${smallHumpTableName}Service.add(param.getData()));
    }

    /**
    * 查询详情
    */
    @ApiOperation(value = "查询详情")
    @PostMapping("/selOne")
    public CustomizeResult<?> selOne(@Valid @RequestBody CommonEntity<IdDto> param){
        return CustomizeResult.success(${smallHumpTableName}Service.getById(param.getData().getId()));
    }

    /**
    * 查询列表
    */
    @ApiOperation(value = "查询列表")
    @PostMapping("/selAll")
    public CustomizeResult<?> selAll(@Valid @RequestBody CommonEntity<${bigHumpTableName}DO> param){
        return CustomizeResult.success(tbTaskTypeInfoService.list(new QueryWrapper<>(param.getData())));
    }

}