package com.superpoet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.superpoet.domain.Dish;
import com.superpoet.dto.DishDto;

public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
