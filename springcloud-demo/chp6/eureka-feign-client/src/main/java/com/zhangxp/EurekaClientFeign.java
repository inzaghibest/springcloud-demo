package com.zhangxp;

import com.zhangxp.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Date 2021/1/20 18:06
 * Created by zhangxp.
 */
// @FeignClient注解来声明一个Feign Client, value指定调用的服务名, configuration指定Feign Client的配置类
@FeignClient(value = "eureka-client", configuration = FeignConfig.class, fallback = HiHystrix.class)
public interface EurekaClientFeign {
    // 接口内部与要调用的方法保持一致。路径，参数
    @GetMapping(value = "/hi1")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
