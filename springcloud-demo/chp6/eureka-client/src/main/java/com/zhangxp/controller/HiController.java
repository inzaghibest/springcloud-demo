package com.zhangxp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/1/18 13:17
 * Created by zhangxp.
 */
@RestController
public class HiController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String Hi() {
        return "hello eureka client!";
    }

    @GetMapping("/hi1")
    public String home(@RequestParam String name) {
        return "hi " + name + "i am from port: " + port;
    }
}
