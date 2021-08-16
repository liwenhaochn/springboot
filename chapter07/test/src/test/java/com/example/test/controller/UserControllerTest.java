package com.example.test.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    /*启用web上下文*/
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void init() throws Exception{
        // 使用上下文构建MockMvc
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void hello() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name())
                .param("name", "chenyijun")
                .accept(MediaType.APPLICATION_JSON).
                        characterEncoding(StandardCharsets.UTF_8.name()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello chenyijun"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertEquals(mvcResult.getResponse().getStatus(), HttpStatus.OK.value());
        Assert.assertEquals(mvcResult.getResponse().getContentAsString(), "hello chenyijun");
    }





}