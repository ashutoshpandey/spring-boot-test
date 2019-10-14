package com.focusit.testing.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /************ Positive test cases *********************/

    @Test
    public void testHelloParam() throws Exception {
        String name = "test";

        this.mockMvc.perform(get("/hello").param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello " + name)));
    }

    @Test
    public void testHelloPath() throws Exception {
        String name = "test2";

        this.mockMvc.perform(get("/hello-path/" + name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello " + name)));
    }

    /************ Negative test cases *********************/

    @Test
    public void testHelloParamNegative() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testHelloPathNegative() throws Exception {
        this.mockMvc.perform(get("/hello-path"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
