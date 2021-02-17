package com.zhangxp.distributed.dao;

import com.zhangxp.distributed.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
