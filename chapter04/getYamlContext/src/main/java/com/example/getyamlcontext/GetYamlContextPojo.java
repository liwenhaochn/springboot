package com.example.getyamlcontext;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("partner")
public class GetYamlContextPojo {
    private String name;
    private String age;
    private List<String> address;
}
