package com.example.startertest;

import com.example.lwh4jspringbootstarter.MyStarter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StarterTestApplicationTests {

    @Autowired
    private MyStarter myStarter;

    @Test
    public void sout(){
        System.out.println(myStarter.print());
    }

}
