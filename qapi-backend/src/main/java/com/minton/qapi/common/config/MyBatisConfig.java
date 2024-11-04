package com.minton.qapi.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.minton.qapi.**.mapper")
public class MyBatisConfig {

}