package com.superpoet.mapper;

import com.superpoet.domain.DishFlavor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Superpoet
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Mapper
* @Entity com.superpoet.domain.DishFlavor
*/
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {

}




