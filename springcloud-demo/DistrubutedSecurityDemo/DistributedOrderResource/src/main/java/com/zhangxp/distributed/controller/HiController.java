package com.zhangxp.distributed.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class HiController {
    @RequestMapping("/hi")
    public String Hi() {
        return "hi, order resource!";
    }

    @RequestMapping("/hi1")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String Hi1() {
        return "hi, order resource!";
    }
}
