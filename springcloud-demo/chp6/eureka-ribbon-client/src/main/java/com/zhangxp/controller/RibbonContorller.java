package com.zhangxp.controller;

import com.zhangxp.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/1/18 17:49
 * Created by zhangxp.
 */
@RestController
public class RibbonContorller {
    @Autowired
    RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "zhangxp") String name)
    {
        return ribbonService.hi1(name);
    }

    // LoadBalancerClient的choose("eureka-client")方法可以轮流得到eureka-client的两个服务实例信息
    @GetMapping("/testRibbon")
    public String testRibbon() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getHost() + " : " + serviceInstance.getPort();
    }
}
