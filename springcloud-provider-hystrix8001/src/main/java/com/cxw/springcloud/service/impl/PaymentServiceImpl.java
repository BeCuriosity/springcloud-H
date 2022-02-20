package com.cxw.springcloud.service.impl;

import com.cxw.springcloud.dao.PaymentDao;
import com.cxw.springcloud.entity.Payment;
import com.cxw.springcloud.service.PaymentService;
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

    @Override
    public String isNotOK(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "not ok" + Thread.currentThread().getName();
    }

    @Override
    public String isOk(Long id) {
        return "ha ha ok";
    }

}
