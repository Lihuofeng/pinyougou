package com.bees360.pojo;

import java.io.Serializable;

public class TbItemCat implements Serializable{
    private Long id;//类目ID

    private Long parentId;//父类目ID=0时，代表的是一级的类目

    private String name;//类目名称

    private Long typeId;//类型id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}