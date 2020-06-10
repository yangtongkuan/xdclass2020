package com.edu.online.model;

import java.util.Date;

/**
 * video order
 * 视频订单表
 */
public class VideoOrder {
    /**
     * CREATE TABLE `video_order` (
     * `id` int unsigned NOT NULL AUTO_INCREMENT,
     * `out_trade_no` varchar(64) DEFAULT NULL COMMENT '订单唯一标识',
     * `state` int DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
     * `create_time` datetime DEFAULT NULL COMMENT '订单生成时间',
     * `total_fee` int DEFAULT NULL COMMENT '支付金额，单位分',
     * `video_id` int DEFAULT NULL COMMENT '视频主键',
     * `video_title` varchar(256) DEFAULT NULL COMMENT '视频标题',
     * `video_img` varchar(256) DEFAULT NULL COMMENT '视频图片',
     * `user_id` int DEFAULT NULL COMMENT '用户id',
     * PRIMARY KEY (`id`)
     * ) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8
     */
    private int id;

    private String outTradeNo;

    private int state;

    private Date createTime;

    private int totalFee;

    private int videoId;

    private String videoTitle;

    private String videoImg;

    private int userId;

    private User user;

    public int getId() {
        return id;
    }

    public VideoOrder setId(int id) {
        this.id = id;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public VideoOrder setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public int getState() {
        return state;
    }

    public VideoOrder setState(int state) {
        this.state = state;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public VideoOrder setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public VideoOrder setTotalFee(int totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public int getVideoId() {
        return videoId;
    }

    public VideoOrder setVideoId(int videoId) {
        this.videoId = videoId;
        return this;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public VideoOrder setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
        return this;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public VideoOrder setVideoImg(String videoImg) {
        this.videoImg = videoImg;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public VideoOrder setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public VideoOrder setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}

