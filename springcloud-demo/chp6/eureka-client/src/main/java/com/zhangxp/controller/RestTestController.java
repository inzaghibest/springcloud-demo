package com.zhangxp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Date 2021/1/18 13:22
 * Created by zhangxp.
 */
@RestController
public class RestTestController {
    @GetMapping("/testRest")
    public String testRest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://www.baidu.com", String.class);
    }
}
