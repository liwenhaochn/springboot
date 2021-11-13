package com.example.jdbctemplate.entity;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Person implements RowMapper<Person> {

    @Id
    private String id;
    private String name;
    private int age;

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getString("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        return person;
    }

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
