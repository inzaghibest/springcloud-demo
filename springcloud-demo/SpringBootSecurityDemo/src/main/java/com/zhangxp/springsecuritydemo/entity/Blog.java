package com.zhangxp.springsecuritydemo.entity;

public class Blog {
    private Long id;
    private String name;
    private String context;

    public Blog(Long id, String name, String context) {
        this.id = id;
        this.name = name;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
