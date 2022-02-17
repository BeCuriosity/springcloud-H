package com.cxw.springcloud.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ApplicationConfig
 * @Author xuwen_chen
 * @Date 2022-02-17 23:16
 * @Version 1.0
 */

@Configuration
public class ApplicationConfig {

    @ConditionalOnMissingBean
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
