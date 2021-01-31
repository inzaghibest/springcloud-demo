package com.zhangxp.springsecuritydemo.service.imp;

import com.zhangxp.springsecuritydemo.entity.Blog;
import com.zhangxp.springsecuritydemo.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    private List<Blog> list = new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1L, "Spring Boot实战", "Spring Boot is Nice!"));
        list.add(new Blog(2L,"Spring Cloud 微服务构建第2版", "Spring Cloud is good!"));
    }
    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(long id) {
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Blog blog = (Blog)iter.next();
            if (blog.getId() == id) {
                iter.remove();
            }
        }
    }
}
