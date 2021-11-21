package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query/{id}")
    User query(@PathVariable int id) {
        return userMapper.queryById(id);
    }

    @RequestMapping("/")
    List<User> queryAll() {
        return userMapper.queryAll();
    }

    @RequestMapping("/add")
    String add(User user) {
        return userMapper.add(user) == 1 ? "success" : "fail";
    }

    @RequestMapping("/delete/{id}")
    String delete(@PathVariable int id) {
        return userMapper.deleteById(id) == 1 ? "success" : "fail";
    }

    @RequestMapping("/update")
    String update(User user) {
        return userMapper.updateById(user) == 1 ? "success" : "fail";
    }


    /**
     * 直接返回分页，在前台控制获取第几页
     */
    @RequestMapping("/page")
    public Page<User> getUserPage(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> userPage = userMapper.getUserPage();
        return userPage;
    }

}
