package com.example.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String id;
    private String name;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*重写toString方法，要不打出来的是哈希值*/
    @Override
    public String toString(){
        /*getName()返回全路径类名*/
        return this.getClass().getSimpleName() +
                "[" + this.getId() +
                ", " + this.getName() +
                ", " + this.getAge() +
                "]";
    }
}
