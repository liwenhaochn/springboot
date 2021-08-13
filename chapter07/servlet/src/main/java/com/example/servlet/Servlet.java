package com.example.servlet;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/*")
public class Servlet extends HttpServlet {

    /*
    * 重写父类方法，客户使用GET方法请求Servlet时，Web容器会调用doGet方法处理请求
    *
    * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet in Servlet");
        response.getWriter().print("Servlet extends HttpServlet");
    }
}
