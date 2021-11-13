package com.example.jpajpql.repository;

import com.example.jpajpql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(true)
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        User user = new User();
        user.setAge(26);
        user.setName("chenyijun");
        user.setId("990008");
        userRepository.save(user);

        user = new User();
        user.setAge(30);
        user.setName("liwenhao");
        user.setId("990007");
        userRepository.save(user);

        user = new User();
        user.setAge(33);
        user.setName("liwenyuan");
        user.setId("990006");
        userRepository.save(user);

        user = userRepository.fetchUserByName("chenyijun");
        System.out.println(user.toString());
        List<User> userList = userRepository.fetchUserListByName("li");
        System.out.println(userList.toString());
    }

}