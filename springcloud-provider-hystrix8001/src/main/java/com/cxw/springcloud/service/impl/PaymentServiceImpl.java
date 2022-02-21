package com.cxw.springcloud.service.impl;

import com.cxw.springcloud.dao.PaymentDao;
import com.cxw.springcloud.entity.Payment;
import com.cxw.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Author xuwen_chen
 * @Date 2022-02-17 1:33
 * @Version 1.0
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }


    @HystrixCommand(fallbackMethod = "isNotOKHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String isNotOK(Long id) {
//        int a = 10/0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "not ok 8001" + Thread.currentThread().getName();
    }
    /**
     * 服务降级的兜底方法
     * @param id id
     * @return
     */
    public String isNotOKHandler(Long id) {
        return "id="+id+" failed--8001-hystrix降级处理" + Thread.currentThread().getName();
    }


    @Override
    public String isOk(Long id) {
        return "ha ha ok";
    }

}
