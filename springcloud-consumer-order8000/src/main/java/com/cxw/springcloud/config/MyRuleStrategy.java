package com.cxw.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRuleStrategy
 * @Author xuwen_chen
 * @Date 2022-02-20 3:31
 * @Version 1.0
 */
@Configuration
public class MyRuleStrategy {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
