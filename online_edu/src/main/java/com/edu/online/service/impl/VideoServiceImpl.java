package com.edu.online.service.impl;

import com.edu.online.domain.Video;
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
}
