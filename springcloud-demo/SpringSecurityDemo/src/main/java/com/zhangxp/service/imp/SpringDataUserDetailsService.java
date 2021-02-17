package com.zhangxp.service.imp;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// 实现UserDetailsService的loadUserByUsername方法，返回UserDetails结构。
//@Service
//public class SpringDataUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//       UserDetails userDetails =  User.withUsername("zhangxp")
//               .password(new BCryptPasswordEncoder().encode("123"))
//               .authorities("ROLE_USER").build();
//        return userDetails;
//    }
//}
