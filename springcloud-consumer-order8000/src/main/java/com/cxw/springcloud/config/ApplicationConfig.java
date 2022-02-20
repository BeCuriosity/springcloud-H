package com.cxw.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ApplicationConfig
 * @Author xuwen_chen
 * @Date 2022-02-17 23:16
 * @Version 1.0
 */

@Configuration
public class ApplicationConfig {


    AtomicInteger atomicInteger;

    @ConditionalOnMissingBean
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        //其中LoadBalanced注解为rest提供服务发现和负载均衡功能
        return new RestTemplate();
    }



}
