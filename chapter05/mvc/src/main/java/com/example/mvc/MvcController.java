package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcController {

    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        model.addAttribute("mvc","Hello, SpringBoot!");
        return "view";
    }

}
