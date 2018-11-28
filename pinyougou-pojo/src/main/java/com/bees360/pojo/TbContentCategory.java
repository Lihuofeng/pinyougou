package com.bees360.pojo;

import java.io.Serializable;

public class TbContentCategory implements Serializable{
    private Long id;//类目ID

    private String name;//分类名称

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
        this.name = name == null ? null : name.trim();
    }
}