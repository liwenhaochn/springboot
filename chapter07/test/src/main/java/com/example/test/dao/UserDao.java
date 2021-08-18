package com.example.test.dao;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 继承JPA接口
 * */
public interface UserDao extends JpaRepository<User, String> {

    /* 一定要注意，这个方法的By后边要和表字段名一样，某则无法加载bean*/
    User getById(String id);
}
