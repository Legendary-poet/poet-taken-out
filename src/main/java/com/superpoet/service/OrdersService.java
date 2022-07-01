package com.superpoet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.superpoet.domain.Orders;


/**
* @author Superpoet
* @description 针对表【orders(订单表)】的数据库操作Service
*/
public interface OrdersService extends IService<Orders> {

   public void submit(Orders orders);
}
