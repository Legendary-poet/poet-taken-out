package com.superpoet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superpoet.domain.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
