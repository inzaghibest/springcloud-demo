package com.zhangxp.distributed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
public class ResourceServerConfig {

    public static final String RESOURCE_ID = "res1";

    // auth资源配置
    @EnableResourceServer
    @Configuration
    public class AuthResourceConfig extends ResourceServerConfigurerAdapter {
        // 自己来验证
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("auth/auth/**").permitAll(); // auth认证服务全部放行
        }
    }

    // order资源配置
    @EnableResourceServer
    @Configuration
    public class OrderResrouceConfig extends ResourceServerConfigurerAdapter {
        // 自己来验证
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("order/order/**").access("#oauth2.hasScope('ROLE_API')");
        }
    }

    // 配置其他资源服务
}
