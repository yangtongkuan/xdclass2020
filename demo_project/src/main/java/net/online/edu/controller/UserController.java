package net.online.edu.controller;

import net.online.edu.domain.User;
import net.online.edu.service.UserService;
import net.online.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:58
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public JsonData loginAuth(@RequestBody User user) {
        System.out.println("username:" + user.getUsername() + ";pwd:" + user.getPwd());
        String token = userService.login(user.getUsername(), user.getPwd());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("账号或者密码错误");
    }
}
