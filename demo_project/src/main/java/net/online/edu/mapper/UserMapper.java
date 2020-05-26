package net.online.edu.mapper;

import net.online.edu.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:16
 * @To change this template use File | Settings | File Templates.
 */
@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jack", new User(1, "jack", "123"));
        userMap.put("xdclass-lw", new User(2, "xdclass-lw", "123456"));
        userMap.put("tom", new User(3, "tom", "123456789"));
    }

    public User login(String username, String pwd) {
        User user = userMap.get(Optional.ofNullable(username).orElse(""));
        if (user == null) {
            return null;
        }
        if (Optional.ofNullable(pwd).orElse("").equals(user.getPwd())) {
            return user;
        }
        return null;
    }

}
