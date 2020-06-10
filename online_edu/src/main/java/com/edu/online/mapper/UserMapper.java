package com.edu.online.mapper;
import com.edu.online.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int saveUser(User user);

    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);
}
