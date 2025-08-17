package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * save a dish
     *
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * dish page query
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pagequery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * delete batch of dishes
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * get dish
     * @param id
     * @return
     */
    DishVO getById(Long id);

    /**
     * update dish
     * @param dishDTO
     */
    void update(DishDTO dishDTO);
}
