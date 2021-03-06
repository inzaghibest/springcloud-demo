package com.zhangxp.springsecuritydemo.controller;

import com.zhangxp.springsecuritydemo.entity.Blog;
import com.zhangxp.springsecuritydemo.service.imp.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView list(Model model) {
        List<Blog> list = blogService.getBlogs();
        model.addAttribute("blogList", list);
        return new ModelAndView("/blogs/list", "blogModel", model);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        blogService.deleteBlog(id);
        model.addAttribute("blogList", blogService.getBlogs());
        return new ModelAndView("/blogs/list", "blogModel", model);
    }


}
