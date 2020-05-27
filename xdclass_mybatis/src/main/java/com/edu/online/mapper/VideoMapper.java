package com.edu.online.mapper;

import com.edu.online.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/26 21:41
 * @To change this template use File | Settings | File Templates.
 */
public interface VideoMapper {

    /**
     * 单个参数参训可以不起别名 如果存在多个参数进行查询的话 会出现找不到参数的情况
     * 强烈建议 增加别名
     *
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId);

    @Select("select * from video")
    List<Video> selectAll();

    List<Video> selectAllByXml();

    /**
     * @param point
     * @param title
     * @return
     * @Desc 对于多个参数传值时 若不指定别名  会报参数名未找到
     */
    List<Video> selectPointAndTitleLike(@Param("point") double point, @Param("title") String title);


    /**
     * 保存视频
     *
     * @param video
     * @return
     */
    int saveVideo(Video video);


    /**
     * 批量新增
     *
     * @param list
     * @return
     */
    int saveBatchVideo(List<Video> list);


}
