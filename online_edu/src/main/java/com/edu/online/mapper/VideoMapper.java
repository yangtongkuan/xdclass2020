package com.edu.online.mapper;

import com.edu.online.model.entity.Video;
import com.edu.online.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    List<Video> videoList();

    List<VideoBanner> listBanner();

    Video findDetailById(@Param("video_id") Integer videoId);
}
