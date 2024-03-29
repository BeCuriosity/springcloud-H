package com.cxw.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @ClassName com.cxw.springcloud.PaymentApplication8004
 * @Author xuwen_chen
 * @Date 2022-02-20 0:26
 * @Version 1.0
 */

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@Slf4j
public class PaymentApplication8004 {
    public static void main(String[] args) {

         //服务注册节点为临时节点
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
