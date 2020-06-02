package com.edu.online.domain;

import java.util.Date;
import java.util.List;

/**
 * user bean
 */
public class User {
    /**
     * CREATE TABLE `user` (
     * `id` int unsigned NOT NULL AUTO_INCREMENT,
     * `name` varchar(128) DEFAULT NULL COMMENT '昵称',
     * `pwd` varchar(124) DEFAULT NULL COMMENT '密码',
     * `head_img` varchar(524) DEFAULT NULL COMMENT '头像',
     * `phone` varchar(64) DEFAULT '' COMMENT '手机号',
     * `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     * PRIMARY KEY (`id`)
     * ) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8
     */
    private Long id;

    private String name;

    private String pwd;

    private String headImg;

    private String phone;

    private Date createTime;

    private List<VideoOrder> videoOrderList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", videoOrderList=" + videoOrderList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public String getHeadImg() {
        return headImg;
    }

    public User setHeadImg(String headImg) {
        this.headImg = headImg;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public List<VideoOrder> getVideoOrderList() {
        return videoOrderList;
    }

    public User setVideoOrderList(List<VideoOrder> videoOrderList) {
        this.videoOrderList = videoOrderList;
        return this;
    }
}
