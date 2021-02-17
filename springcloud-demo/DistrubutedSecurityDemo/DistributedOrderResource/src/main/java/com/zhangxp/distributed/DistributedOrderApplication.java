package com.zhangxp.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DistributedOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributedOrderApplication.class, args);
    }
}
