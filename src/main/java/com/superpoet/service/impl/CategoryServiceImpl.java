package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.superpoet.domain.Category;
import com.superpoet.mapper.CategoryMapper;
import com.superpoet.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

}
