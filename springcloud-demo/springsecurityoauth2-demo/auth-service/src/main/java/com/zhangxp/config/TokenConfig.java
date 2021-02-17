package com.zhangxp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description
 * @Date 2021/2/1 14:30
 * Created by zhangxp.
 */
//@Configuration
//public class TokenConfig {
//
//    // 令牌存储策略,使用内存存储令牌，生成普通令牌
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//}

// 生成JWT令牌
@Configuration
public class TokenConfig {
    // jwt令牌的秘钥
    private String STRING_KEY = "auth123";

    // jwt令牌存储方式
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(STRING_KEY);
        return converter;
    }
}
