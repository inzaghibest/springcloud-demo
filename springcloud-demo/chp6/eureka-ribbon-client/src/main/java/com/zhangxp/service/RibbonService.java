package com.zhangxp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Date 2021/1/18 17:47
 * Created by zhangxp.
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    // @HystrixCommand注解使hi1方法开启熔断器功能，并指定处理回退的逻辑方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi1(String name) {
        return restTemplate.getForObject("http://eureka-client/hi1?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi, " + name + ", sorry, error!";
    }
}
