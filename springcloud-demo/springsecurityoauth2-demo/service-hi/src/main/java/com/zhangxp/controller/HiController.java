package com.zhangxp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/2/4 14:15
 * Created by zhangxp.
 */
@RestController
public class HiController {
    @GetMapping("/hi")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String Hi() {
        return "hello hi!";
    }
}
