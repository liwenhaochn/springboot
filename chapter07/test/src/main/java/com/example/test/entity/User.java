package com.example.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    @Id
    private String id;
    private String name;
    private int age;

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
