package com.edu.online.controller;

import com.edu.online.domain.Video;
import com.edu.online.domain.VideoBanner;
import com.edu.online.service.VideoService;
import com.edu.online.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 查询视频列表信息
     *
     * @return
     */
    @RequestMapping("/list")
    public JsonData videoList() {
        List<Video> videoList = videoService.videoList();
        return JsonData.buildSuccess(videoList);
    }

    // 获取视频详情
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam("video_id") Integer videoId) {
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }

    /**
     * 获取轮播图列表
     *
     * @return
     */
    @GetMapping("/list_banner")
    public JsonData videoListBanner() {
        List<VideoBanner> listBanner = videoService.listBanner();
        return JsonData.buildSuccess(listBanner);
    }
}
