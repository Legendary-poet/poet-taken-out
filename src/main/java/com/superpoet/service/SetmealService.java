package com.superpoet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.superpoet.domain.Setmeal;
import com.superpoet.dto.SetmealDto;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
   public void saveWithDish(SetmealDto setmealDto);

   public void removeWithDish(List<Long> ids);
}
