package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("var", "Hello, SpringBoot!!!");
        return "view";
    }
}
