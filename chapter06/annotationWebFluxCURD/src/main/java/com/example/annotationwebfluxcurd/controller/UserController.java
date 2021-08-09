package com.example.annotationwebfluxcurd.controller;

import com.example.annotationwebfluxcurd.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/annotationWebFluxCURD")
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

    @GetMapping("/getall")
    public Flux<User> getAll(){
        return Flux.fromIterable(users.entrySet().stream().map(entity -> entity.getValue()).collect(Collectors.toList()));
    }

    /*
    * 这里的id是users的第1个Long类型的元素（1或2）
    * */
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id){
        return Mono.justOrEmpty(users.get(id));
    }

    /*
    * 添加用户
    * */
    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User user){
        users.put(user.getId(),user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }
    /*
    * 修改用户
    * */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> amendUser(@PathVariable Long id, User user){
        user.setId(id);
        users.put(id,user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    /*
    * 删除用户
    * */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id){
        users.remove(id);
        return Mono.just(new ResponseEntity<>("删除成功", HttpStatus.ACCEPTED));
    }


}
