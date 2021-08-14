package com.example.throwsexception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/*
*
* 这是一个处理错误的controller，和一般的controller不同的是，他里边的方法可以处理异常的访问，也可以处理正常的访问
*
* 异常----->handler----->异常
*
* */
@RestController
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

    //    @Override
    public String getErrorPath() {
        return null;
    }

    /*
     * 一定要添加URL映射，指向error
     * */
    @RequestMapping
    public Map<String, Object> handleError() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 404);
        map.put("msg", "1-not exists");
        return map;
    }

    @RequestMapping("/normal")
    public Map<String, Object> noError() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "normal");
        return map;
    }

    /*
    *
    * 和handleError重复，优先使用的是handleError
    * */
    @RequestMapping(value = "", consumes = "application/xml;charset=UTF-8",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String errorHtml404(HttpServletRequest request, HttpServletResponse response) {
        return "404 error,not exists";
    }

    @RequestMapping(value = "", consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public Map<String, Object> errorJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 404);
        map.put("msg", "errorJson not exists");
        return map;
    }
}
