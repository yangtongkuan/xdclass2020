package net.online.edu.service.impl;

import net.online.edu.domain.User;
import net.online.edu.mapper.UserMapper;
import net.online.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:23
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Map<String, User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {
        User user = userMapper.login(username, pwd);
        if (user == null) {
            return null;
        } else {
            String token = UUID.randomUUID().toString();
            sessionMap.put(token, user);
            return token;
        }
    }

    @Override
    public User getUserByToken(String token) {
        return StringUtils.isEmpty(token) ? null : sessionMap.get(token);
    }
}
