package net.online.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:15
 * @To change this template use File | Settings | File Templates.
 */
public class User {
    private int id;

    private String username;

    @JsonIgnore
    private String pwd;

    public User() {

    }


    public User(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
