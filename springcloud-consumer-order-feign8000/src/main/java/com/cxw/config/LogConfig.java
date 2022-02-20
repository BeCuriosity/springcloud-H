package com.cxw.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName LogConfig
 * @Author xuwen_chen
 * @Date 2022-02-20 19:41
 * @Version 1.0
 */

@Configuration
public class LogConfig {

    @Bean
    public Logger.Level feignLog() {
        return Logger.Level.FULL;
    }
}
