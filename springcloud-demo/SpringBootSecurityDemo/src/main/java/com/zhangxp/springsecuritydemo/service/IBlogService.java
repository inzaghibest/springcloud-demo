package com.zhangxp.springsecuritydemo.service;

import com.zhangxp.springsecuritydemo.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    void deleteBlog(long id);
}
