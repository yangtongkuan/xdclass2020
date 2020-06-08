package com.edu.online.service;

import com.edu.online.domain.Video;
import com.edu.online.domain.VideoBanner;
import org.springframework.boot.Banner;

import java.util.List;

public interface VideoService {
    List<Video> videoList();

    List<VideoBanner> listBanner();

    Video findDetailById(Integer videoId);
}
