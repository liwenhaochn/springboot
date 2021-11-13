package com.example.jpanative.repository;

import com.example.jpanative.entity.User;
import com.example.jpanative.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;


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

        user = userRepository.fetchUserById("990008");
        System.out.println(user.toString());
        List<User> userList = userRepository.fetchAll();
        System.out.println(userList.toString());

        Pageable pageable = PageRequest.of(0, 1);
        Page<User> userPage = userRepository.fetchUserPageByName("li", pageable);
        System.out.println(userPage.toString());
        userRepository.updateUserAgeByName("chenyijun",24);
        user = userRepository.fetchUserById("990008");
        System.out.println(user);
        userRepository.deleteByName("liwenhao");
        userList = userRepository.fetchAll();
        System.out.println(userList.toString());

    }

}