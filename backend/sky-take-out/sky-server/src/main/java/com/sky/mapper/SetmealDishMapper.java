package com.sky.mapper;

import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * get dish id
     * @param ids
     * @return
     */
    List<Long> getByDishId(List<Long> ids);

}
