package com.example.jpajpql.repository;

import com.example.jpajpql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    /*
    * jpql的常用方式
    *
    * */

    @Query("select u from User u where u.name = ?1")
    User fetchUserByName(String name);

    @Query("select u from User u where u.name like %?1%")
    List<User> fetchUserListByName(String name);



}
