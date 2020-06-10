package com.edu.online.service.impl;

import com.edu.online.model.entity.User;
import com.edu.online.mapper.UserMapper;
import com.edu.online.model.request.LoginRequest;
import com.edu.online.service.UserService;
import com.edu.online.utils.CommonUtils;
import com.edu.online.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null) {
            User userByPhone = userMapper.findByPhone(user.getPhone());
            if (userByPhone != null) {
                return 0;
            }
            return userMapper.saveUser(user);
        } else {
            return -1;
        }
    }

    /**
     * 登录认证
     *
     * @param login
     * @return
     */
    @Override
    public String loginByPhone(LoginRequest login) {
        String pwd = CommonUtils.MD5(login.getPwd());
        User userByPhone = userMapper.findByPhoneAndPwd(login.getPhone(), pwd);
        if (userByPhone != null) {
            return JWTUtils.geneJsonWebToken(userByPhone);
        }
        return null;
    }

    /**
     * 解析 user 对象
     *
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            //MD5加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        } else {
            return null;
        }
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String[] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg() {
        return headImg[new Random().nextInt(headImg.length)];
    }


}
