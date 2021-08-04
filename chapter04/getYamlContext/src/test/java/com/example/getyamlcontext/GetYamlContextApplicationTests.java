package com.example.getyamlcontext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GetYamlContextApplicationTests {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${partner.name}")
    private String pname;

    @Value("${partner.age}")
    private String page;

    @Test
    public void showName(){
        System.out.println(name);
    }

    @Test
    public void showAge(){
        System.out.println(age);
    }

    @Test
    public void showPName(){
        System.out.println(pname);
    }

    @Test
    public void showPAge(){
        System.out.println(page);
    }

    @Autowired
    private GetYamlContextPojo getYamlContextPojo;
    @Test
    @DisplayName("get yaml config by pojo")
    public void showPartner(){
        System.out.println(getYamlContextPojo.getName());
        System.out.println(getYamlContextPojo.getAge());
        System.out.println(getYamlContextPojo.getAddress());
    }

}
