package com.zhangxp.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthServerApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplicaiton.class, args);
    }
}
