package com.example.mybatis.controller;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController2 {

    @Autowired
    private UserMapper userMapper;




    @RequestMapping("/pages")
    public String getPageWithModel(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                                   @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id asc");
        List<User> userList = userMapper.queryAll();
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("page", page);
        return "listUser";
    }

}
