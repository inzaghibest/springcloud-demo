package com.zhangxp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Date 2021/1/18 18:10
 * Created by zhangxp.
 */
@EnableEurekaClient
@SpringBootApplication
public class RibbonClientApplication {
    public static void main(String[] args) {
         SpringApplication.run(RibbonClientApplication.class, args);
    }
}
