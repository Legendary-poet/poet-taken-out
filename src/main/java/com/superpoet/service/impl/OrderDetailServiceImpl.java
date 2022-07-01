package com.superpoet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.superpoet.domain.OrderDetail;
import com.superpoet.mapper.OrderDetailMapper;
import com.superpoet.service.OrderDetailService;
import org.springframework.stereotype.Service;


 //订单明细表(OrderDetail)表服务实现类

@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}

