package com.example.defineannotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefineAnnotationController {

    @GetMapping("/defineAnnotation")
    @DefineAnnotation("controller")
    public String hello(){
        return "define annotation!";
    }
}
