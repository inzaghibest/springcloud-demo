package com.zhangxp.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*
* spirng security2.0版本开始，提供了方法级别的安全支持，比提供了JSR-250的支持。
* @EnableGlobalMethodSecurity注解开启了方法级别的保护，括号后面的参数可选，可选参数如下：
* prePostEnabled: Spring Security的Pre和Post注解是否可用，即@PreAuthorize和@PostAuthorize是否可用
* secureEnabled: Spring Security的@Secured注解是否可用
* jsr250Enabled: Spring Security的JSR-250注解是否可用
* 一般来说，只会用到prePostEnable注解。因为@PreAuthorize和@PostAuthorize注解更适合方法级别的安全控制，并且支持Spring EL表达式
* @Pre注解在进入方法前进行验证，@Post注解在方法执行后再进行权限验证，应用场景很少
* @PreAuthorize("hasRole('ADMIN')") 或@PreAuthorize(hasAuthority('ROLE_ADMIN'))
* @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
* */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     */
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*在内存中创建用户信息*/
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangxp")
//                .password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
        auth.userDetailsService(userDetailsService);
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 在内存中存放用户信息
//        manager.createUser(User.withUsername("zhangxp").password(passwordEncoder().encode("123456")).roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("123456")).roles("USER","ADMIN").build());
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().failureUrl("/login-error")
//                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
    }
}
