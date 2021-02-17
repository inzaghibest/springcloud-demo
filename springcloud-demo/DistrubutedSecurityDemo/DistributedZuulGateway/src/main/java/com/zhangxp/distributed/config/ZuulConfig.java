package com.zhangxp.distributed.config;

import com.zhangxp.distributed.filters.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
