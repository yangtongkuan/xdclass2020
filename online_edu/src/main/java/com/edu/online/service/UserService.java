package com.edu.online.service;

import com.edu.online.model.entity.User;
import com.edu.online.model.request.LoginRequest;

import java.util.Map;

public interface UserService {

    int saveUser(Map<String, String> userInfo);

    String loginByPhone(LoginRequest login);

    User findById(Integer userId);
}
