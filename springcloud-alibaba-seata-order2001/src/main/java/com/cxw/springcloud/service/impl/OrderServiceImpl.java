package com.cxw.springcloud.service.impl;

import com.cxw.springcloud.dao.OrderDao;
import com.cxw.springcloud.entity.Order;
import com.cxw.springcloud.service.AccountService;
import com.cxw.springcloud.service.OrderService;
import com.cxw.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Author xuwen_chen
 * @Date 2022-03-01 23:25
 * @Version 1.0
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    AccountService accountService;

    @Resource
    StorageService storageService;

    @Override
    public void create(Order order) {

        log.info("开始下订单");
        orderDao.create(order);

        log.info("---减库存---");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("减余额");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("改状态");
        orderDao.update(order.getUserId(), 0);


        log.info("下单结束");

    }

}
