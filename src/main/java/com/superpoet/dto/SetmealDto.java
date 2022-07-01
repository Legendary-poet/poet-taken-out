package com.superpoet.dto;


import com.superpoet.domain.Setmeal;
import com.superpoet.domain.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
