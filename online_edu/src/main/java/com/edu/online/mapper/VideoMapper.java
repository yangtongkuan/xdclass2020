package com.edu.online.mapper;

import com.edu.online.domain.Video;
import com.edu.online.domain.VideoBanner;

import java.util.List;

public interface VideoMapper {
    List<Video> videoList();

    List<VideoBanner> listBanner();

    Video findDetailById(Integer videoId);
}
