package net.online.edu.controller;

import junit.framework.TestCase;
import net.online.edu.OnlineEduApplication;
import net.online.edu.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = {OnlineEduApplication.class})
@AutoConfigureMockMvc
public class TestController {

    @Autowired
    private UserService userService;

    //
    @Autowired
    private MockMvc mockMvc;

    // test 之前执行
    @Before
    public void testBefore() {
        System.out.println("test --->before");
    }

    // 测试service
    @Test
    public void test1() {
        String username = "jack";
        String pwd = "1234";
        String token = userService.login(username, pwd);
        // 使用断言 判断是否执行成功了
        TestCase.assertNotNull(token);
    }

    @Test
    public void testController() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getContentAsString(Charset.forName("utf-8")));
    }


    // test 之后执行
    @After
    public void testAfter() {
        System.out.println("test --->after");
    }
}

