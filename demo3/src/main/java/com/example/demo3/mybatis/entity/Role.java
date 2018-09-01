package com.example.demo3.mybatis.entity;
import java.io.Serializable;

/**
 * @author lanxinghua
 * @date 2018/09/01 14:48
 * @description
 */
public class Role implements Serializable {

    private String id;

    private String name;

    private String describtions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribtions() {
        return describtions;
    }

    public void setDescribtions(String describtions) {
        this.describtions = describtions;
    }
}