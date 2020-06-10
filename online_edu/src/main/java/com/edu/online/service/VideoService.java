package com.edu.online.service;

import com.edu.online.model.entity.Video;
import com.edu.online.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> videoList();

    List<VideoBanner> listBanner();

    Video findDetailById(Integer videoId);
}
