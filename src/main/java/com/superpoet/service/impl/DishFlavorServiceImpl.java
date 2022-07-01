package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superpoet.domain.DishFlavor;
import com.superpoet.service.DishFlavorService;
import com.superpoet.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author Superpoet
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




