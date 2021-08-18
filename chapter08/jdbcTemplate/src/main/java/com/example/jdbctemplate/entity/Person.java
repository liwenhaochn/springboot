package com.example.jdbctemplate.entity;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
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
