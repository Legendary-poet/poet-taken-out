package com.superpoet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.superpoet.domain.OrderDetail;

import org.apache.ibatis.annotations.Mapper;

/**
* @author Superpoet
* @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
* @Entity generator.domain.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}




