package com.edu.online.sp.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/6/3 22:44
 * @To change this template use File | Settings | File Templates.
 */
public class Video {
    private Long id;
    private String title;

    private List<String> orderList;

    private Map<Integer, String> videoMap;

    public List<String> getOrderList() {
        return orderList;
    }

    public Video setOrderList(List<String> orderList) {
        this.orderList = orderList;
        return this;
    }

    public Map<Integer, String> getVideoMap() {
        return videoMap;
    }

    public Video setVideoMap(Map<Integer, String> videoMap) {
        this.videoMap = videoMap;
        return this;
    }

    public Video() {
        System.out.println("video 空构造器执行了~~");
    }

    public Video(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void init() {
        System.out.println("video init~~~~");
    }

    public void destory(){
        System.out.println("video destory ~~~~");
    }
}
