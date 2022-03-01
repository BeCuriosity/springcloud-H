package com.cxw.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Author xuwen_chen
 * @Date 2022-03-01 23:42
 * @Version 1.0
 */

@Configuration
@MapperScan("com.cxw.springcloud.dao")
public class MybatisConfig {
    //数据源代理类、暂时不写
}
