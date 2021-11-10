package com.example.mvcwithbean.controller;

import com.example.mvcwithbean.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcWithBeanController {

    @GetMapping("/mvcWithBean")
    public ModelAndView mvcWithBean() {
        User user = new User();
        user.setAge(29);
        user.setName("liwenhao");
        user.setId(100034);
        // 看了ModelAndView的定义，才发现这里的传参是view的名字，而不是路径，书上是错误的
        ModelAndView modelAndView = new ModelAndView("modelAndView");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
