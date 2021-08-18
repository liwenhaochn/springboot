package com.example.webfluxcurdwithmongodb.controller;

import com.example.webfluxcurdwithmongodb.entity.User;
import com.example.webfluxcurdwithmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.Duration;

@RestController
@RequestMapping(path = "/webFluxCURDWithMongodb")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/getalldelay")
    public Flux<User> getAllDelay() {
        return userRepository.findAll().delayElements(Duration.ofSeconds(BigDecimal.ONE.longValue()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable String id) {
        return userRepository.findById(id)
                .map(getUser -> ResponseEntity.ok(getUser))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    /*创建用户*/
    @PostMapping("")
    public Mono<User> createUser(@Valid User user) {
        return userRepository.save(user);
    }

    /*更新用户*/
    @PutMapping("/{id}")
    public Mono updateUser(@PathVariable String id, @Valid User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    // 年龄也更新
                    existingUser.setAge(user.getAge());
                    return userRepository.save(existingUser);
                }).map(update -> new ResponseEntity<>(update, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*删除用户*/
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable(value = "id") String id) {
        return userRepository.findById(id)
                .flatMap(ex -> userRepository.delete(ex)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
