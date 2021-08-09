package com.example.annotationwebfluxcurd.controller;

import com.example.annotationwebfluxcurd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {
    Map<Long, User> users = new HashMap<>();

    /*
     * The PostConstruct annotation is used on a method that needs to be executed
     * after dependency injection is done to perform any initialization.
     */
    @PostConstruct
    public void init() throws Exception {
        users.put(Long.valueOf(1), new User(990001, "liwenhao", 30));
        users.put(Long.valueOf(2), new User(990002, "chenyijun", 26));
    }

    @GetMapping("/annotationWebFluxCURD")
    public Flux<User> getAll(){
        return Flux.fromIterable(users.entrySet().stream().map(entity -> entity.getValue()).collect(Collectors.toList()));
    }

}
