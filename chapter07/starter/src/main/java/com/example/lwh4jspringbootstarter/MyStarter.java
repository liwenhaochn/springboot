package com.example.lwh4jspringbootstarter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
/*
* 核心服务类
* */
@NoArgsConstructor
@AllArgsConstructor
public class MyStarter {

    private MyStarterProperties myStarterProperties;

    public String print(){
        System.out.println("参数：" + myStarterProperties.getParameter());
        String s = myStarterProperties.getParameter();
        return s;
    }

}
