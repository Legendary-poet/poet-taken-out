package com.superpoet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superpoet.domain.Orders;

import org.apache.ibatis.annotations.Mapper;

/**
* @author Superpoet
* @description 针对表【orders(订单表)】的数据库操作Mapper
* @Entity generator.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}




