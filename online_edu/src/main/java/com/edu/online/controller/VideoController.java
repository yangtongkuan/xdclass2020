package com.edu.online.controller;

import com.edu.online.domain.Video;
import com.edu.online.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/list")
    public List<Video> videoList() {
        System.out.println("11111");
        return videoService.videoList();
    }
}
