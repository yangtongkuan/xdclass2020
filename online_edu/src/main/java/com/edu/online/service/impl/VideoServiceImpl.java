package com.edu.online.service.impl;

import com.edu.online.model.entity.Video;
import com.edu.online.model.entity.VideoBanner;
import com.edu.online.mapper.VideoMapper;
import com.edu.online.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> videoList() {
        return videoMapper.videoList();
    }

    /**
     * 获取视频轮播图
     *
     * @return
     */
    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listBanner();
    }

    /**
     * 获取视频详情-章集-待补充
     *
     * @param videoId
     * @return
     */
    @Override
    public Video findDetailById(Integer videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
