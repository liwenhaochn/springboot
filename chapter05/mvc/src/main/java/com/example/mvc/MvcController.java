package com.example.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        model.addAttribute("var","hello,Spring MVC!");
        return "view";
    }
}
