package com.zhangxp.service;

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

    public String hi1(String name) {
        return restTemplate.getForObject("http://eureka-client/hi1?name=" + name, String.class);
    }
}
