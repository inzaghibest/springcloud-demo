package com.zhangxp.distributed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DistributedSecurityGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributedSecurityGatewayApplication.class, args);
    }
}

//https://cloud.tencent.com/developer/article/1450984
