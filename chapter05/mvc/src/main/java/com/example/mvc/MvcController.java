package com.example.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

    @RequestMapping("/mvc")
    public String mvc(Model model) throws Exception {
        model.addAttribute("var", "hello,Spring MVC!");
        return "view";
    }
}
