package net.online.edu.service;

import net.online.edu.domain.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:23
 * @To change this template use File | Settings | File Templates.
 */
public interface UserService {

    String login(String username, String pwd);

    User getUserByToken(String token);
}
