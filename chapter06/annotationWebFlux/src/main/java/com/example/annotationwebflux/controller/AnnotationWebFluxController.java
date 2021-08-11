package com.example.annotationwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AnnotationWebFluxController {

    @GetMapping("/annotationWebFlux")
    public Mono<String> annotationWebFlux() {
        return Mono.just("Hello~~, This is WebFlux by annotation!!");
    }
}
