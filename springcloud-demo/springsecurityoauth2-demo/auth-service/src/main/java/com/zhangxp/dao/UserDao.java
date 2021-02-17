package com.zhangxp.dao;

import com.zhangxp.entity.User;
import com.zhangxp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
