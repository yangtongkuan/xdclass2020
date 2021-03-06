package com.edu.online.controller;

import com.edu.online.model.entity.User;
import com.edu.online.model.request.LoginRequest;
import com.edu.online.service.UserService;
import com.edu.online.utils.JsonData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.saveUser(userInfo);
        if (rows == 1) {
            return JsonData.buildSuccess();
        } else if (rows == 0) {
            return JsonData.buildError("当前账号已注册,请直接登录");
        }
        return JsonData.buildError("注册失败,请重试");
    }

    /**
     * 通过手机号和密码登录
     *
     * @param login
     * @return
     */
    @PostMapping("/login")
    public JsonData login(@RequestBody LoginRequest login) {
        String token = userService.loginByPhone(login);
        return StringUtils.isNotEmpty(token) ? JsonData.buildSuccess(token) : JsonData.buildError("用户名或密码错误");
    }

    /**
     * 分局token获取用户信息
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData find_by_token(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("user_id");
        User user = userService.findById(userId);
        return JsonData.buildSuccess(user);
    }


}
