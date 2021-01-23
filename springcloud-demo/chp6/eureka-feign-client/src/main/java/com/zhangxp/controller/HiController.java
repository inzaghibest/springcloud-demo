package com.zhangxp.controller;

import com.zhangxp.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/1/20 18:09
 * Created by zhangxp.
 */
@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "zhangxp", required = false) String name)
    {
        return hiService.sayHi(name);
    }
}
