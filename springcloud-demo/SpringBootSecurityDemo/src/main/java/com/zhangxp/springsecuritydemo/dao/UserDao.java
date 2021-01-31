package com.zhangxp.springsecuritydemo.dao;

import com.zhangxp.springsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
