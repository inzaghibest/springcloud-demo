package com.zhangxp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "foo")
    public String Hi() {
        return foo;
    }

}
