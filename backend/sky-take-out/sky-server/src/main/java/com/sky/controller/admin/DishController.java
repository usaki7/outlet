package com.sky.controller.admin;


import com.github.pagehelper.Page;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish category api")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * add a dish
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("add dish")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("add dish:{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * page query
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("page query")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        PageResult pageResult = dishService.pagequery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * delete batch of dishes
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("delete dish")
    public Result delete(@RequestParam List<Long> ids){
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("get dish")
    public Result<DishVO> getById(@PathVariable Long id){

        DishVO dishVO = dishService.getById(id);
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("update dish")
    public Result update(@RequestBody DishDTO dishDTO){

        dishService.update(dishDTO);
        return Result.success();
    }
}
