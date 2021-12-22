package com.example.template.controller;

import com.example.template.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TemplateController {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(User user) {
        return user;
    }

    @RequestMapping(value = "getDefaultUser", method = RequestMethod.GET)
    public User getDefaultUser() {
        return new User();
    }

    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    public User postUser(User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user;
    }

    @RequestMapping("/success")
    public String loginSuccess(String name) {
        return "welcome" + name;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "id", required = false) Long id,
                        HttpServletResponse response) {
        // 如果获取的值为“null”，则需要把URI添加到response信息的header中
        String str = "redirect:/success?name=" + name + "&id=" + id + "&status=success";
        response.addHeader("Location", str);
        return str;
    }

    // TODO 这里无法传User到这里
    @RequestMapping(value = "/{id}")
    public String modify(@PathVariable long id, User user) {
        System.out.println(id);
        System.out.println(user);
        return "modify" + id;
    }

}
