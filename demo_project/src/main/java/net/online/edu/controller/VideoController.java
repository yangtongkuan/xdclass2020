package net.online.edu.controller;

import net.online.edu.domain.Video;
import net.online.edu.service.VideoService;
import net.online.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:14
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public Object list() {
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());

        return JsonData.buildSuccess(video);

    }
}
