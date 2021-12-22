package com.example.template;

import com.example.template.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TemplateApplicationTests {

    public final static String link_first = "http://localhost:8009/getUser";
    public final static String link_second = "http://localhost:8009/getDefaultUser";
    public final static String link_third = "http://localhost:8009/postUser";
    public final static String link_fourth = "http://localhost:8009/login";
    public final static String link_fifth = "http://localhost:8009/{1}";
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     *
     */
    @Test
    void getUserTest() {
        System.out.println("222---通过占位符返回String");
        RestTemplate client = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity(link_first + "?name={1}&id={2}", String.class,
                "liwenhao", 100);
        System.out.println(responseEntity.getBody());

        System.out.println("333---通过map返回String");
        Map<String, String> map = new HashMap<>();
        map.put("name", "chenyijun");
        responseEntity = client.getForEntity(link_first + "?name={name}&id=200", String.class, map);
        System.out.println(responseEntity.getBody());
    }

    @Test
    void getDefaultUserTest() {
        System.out.println("111---不带参数返回String");
        RestTemplate client = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity(link_second, String.class);
        System.out.println(responseEntity.getBody());

        System.out.println("444---返回对象");
        ResponseEntity<User> userResponseEntity = client.getForEntity(link_second, User.class);
        System.out.println(userResponseEntity.getBody().getId());
        System.out.println(userResponseEntity.getBody().getName());

        System.out.println("555---使用getForObject返回对象");
        User user = client.getForObject(link_second, User.class);
        System.out.println(user.getId());
        System.out.println(user.getName());
    }

    @Test
    public void postUserTest() {
        System.out.println("666---通过postForEntity发送post请求");
        RestTemplate client = restTemplateBuilder.build();
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("id", 300);
        multiValueMap.add("name", "laoda");
        ResponseEntity<User> responseEntity = client.postForEntity(link_third, multiValueMap,
                User.class);
        System.out.println(responseEntity.getBody().getId());
        System.out.println(responseEntity.getBody().getName());


        System.out.println("777---通过postForObject发送post请求");
        multiValueMap.clear();
        multiValueMap.add("id", 400);
        multiValueMap.add("name", "laoer");
        String response = client.postForObject(link_third, multiValueMap, String.class);
        System.out.println(response);

        System.out.println("888---通过exchange发送post请求");
        multiValueMap.clear();
        multiValueMap.add("id", 500);
        multiValueMap.add("name", "laosan");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity =
                new HttpEntity<MultiValueMap<String, Object>>(multiValueMap, httpHeaders);
        ResponseEntity<String> stringResponseEntity = client.exchange(link_third, HttpMethod.POST, httpEntity,
                String.class, multiValueMap);
        System.out.println(stringResponseEntity.getBody());

        System.out.println("999---通过postForLocation发送post请求");
        multiValueMap.clear();
        multiValueMap.add("id", 600);
        multiValueMap.add("name", "laosi");
        URI uri = client.postForLocation(link_fourth, multiValueMap);
        System.out.println(uri);
    }

    @Test
    public void modifyTest() {
        RestTemplate client = restTemplateBuilder.build();
        User user = new User();
        user.setName("laowu");

        client.put("http://localhost:8009/{1}", user, 1);
        client.delete("http://localhost:8009/{1}", 3);
    }

}
