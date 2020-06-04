package com.edu.online.sp.domain;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/6/3 22:44
 * @To change this template use File | Settings | File Templates.
 */
public class Video1 {
    private Long id;
    private String title;

    private String summary;

    private List<String> orderList;

    private Map<Integer, String> videoMap;

    public List<String> getOrderList() {
        return orderList;
    }

    public String getSummary() {
        return summary;
    }

    public Video1 setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Video1 setOrderList(List<String> orderList) {
        this.orderList = orderList;
        return this;
    }

    public Map<Integer, String> getVideoMap() {
        return videoMap;
    }

    public Video1 setVideoMap(Map<Integer, String> videoMap) {
        this.videoMap = videoMap;
        return this;
    }

    public Video1() {
    }

    public Video1(String title) {
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
}
