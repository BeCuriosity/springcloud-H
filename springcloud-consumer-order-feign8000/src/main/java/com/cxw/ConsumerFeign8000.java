package com.cxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ConsumerFeign8000
 * @Author xuwen_chen
 * @Date 2022-02-20 18:33
 * @Version 1.0
 */

@SpringBootApplication
@EnableFeignClients
public class ConsumerFeign8000 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign8000.class, args);
    }
}
