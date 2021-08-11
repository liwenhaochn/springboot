package com.example.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WebFluxRouter {
    @Autowired
    private WebFluxHandler webFluxHandler;

    @Bean
    public RouterFunction<ServerResponse> getString() {
        return route(GET("/webflux"), req -> webFluxHandler.hello(req));
    }
}
