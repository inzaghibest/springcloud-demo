package com.zhangxp.config;

//import com.zhangxp.service.imp.SpringDataUserDetailsService;
import com.zhangxp.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 基于内存的用户信息
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zhangxp").password(passwordEncoder().
//                encode("1234")).roles("USER").build());
//        manager.createUser(User.withUsername("admin").password(passwordEncoder()
//        .encode("123")).roles("ADMIN", "USER").build());
//        return manager;
//
//    }

    @Autowired
    UserDetailsService userDetailsService;
    //SpringDataUserDetailsService userDetailsService;
    @Autowired
    public void  configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("zhangxp").
//                password(passwordEncoder().encode("123")).
//                authorities("USER").roles("USER");
    //        auth.userDetailsService(userDetailsService);
    }


    // 密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 安全拦截机制
    * configure(HttpSecurity http)用来配置是否所有用户都需要身份验证？工程的哪些资源需要验证？哪些不需要验证等等都需要覆写此方法
    * 实现。
    * 以/css/**开头的资源和/index资源不需要验证，外接请求可以直接访问这些资源。
      以/user/**和blogs/**开头的资源需要验证，并且需要用户的角色为"USER"
      表单登录的地址是/login,登录失败的地址是/login-error
      异常处理会重定向到/401页面
      注销登录成功会重定向到首页。
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index", "/login").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/blogs/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}
