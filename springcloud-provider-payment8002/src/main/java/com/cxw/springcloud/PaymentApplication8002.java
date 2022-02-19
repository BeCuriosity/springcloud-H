package com.cxw.springcloud;

import com.cxw.springcloud.dao.PaymentDao;
import com.cxw.springcloud.entity.Payment;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.Resource;

/**
 * @ClassName PaymentApplication8001
 * @Author xuwen_chen
 * @Date 2022-02-15 23:45
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8002 implements ApplicationRunner {

    @Resource
    private PaymentDao paymentDao;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Payment byId = paymentDao.getById(1L);
        System.out.println(byId.toString());
    }
}
