package com.edu.online;

import com.edu.online.domain.Video;
import com.edu.online.mapper.VideoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/26 21:34
 * @To change this template use File | Settings | File Templates.
 */
public class MybatisApplication {

    public static void main(String[] args) throws IOException {
        String source = "config/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(source);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        try (SqlSession session = sessionFactory.openSession()) {
            VideoMapper mapper = session.getMapper(VideoMapper.class);
//            Video video = mapper.selectById(44);
//            System.out.println(video.toString());
            // 通过注解获取 简单的查询还是可以的 对于复杂的查询有点费劲
//            List<Video> videoList = mapper.selectAll();
//            List<Video> videoList = mapper.selectAllByXml();
//            System.out.println(videoList);
            // 模糊查询
            // List<Video> pointAndTitleLike = mapper.selectPointAndTitleLike(8.7, "HTML");
            // System.out.println(pointAndTitleLike);
            // 添加一个video
            // Video video = new Video();
            // video.setTitle("程序员成长专题111");
            // video.setCoverImg("xdclass.net/a1111.png");
            // video.setCreateTime(new Date());
            // video.setPoint(9.11);
            // video.setPrice(1111);
            // int rows = mapper.saveVideo(video);
            // System.out.println(rows);
            // System.out.println(video);
            // 批量插入~~
            // video1.setTitle("程序员成长专题111");
            // video1.setCoverImg("xdclass.net/a1111.png");
            // video1.setCreateTime(new Date());
            // video1.setPoint(9.11);
            // video1.setPrice(1111);
            // video1.setSummary("这是专题课程111");
            //
            // Video video2 = new Video();
            // video2.setTitle("程序员成长专题");
            // video2.setCoverImg("xdclass.net/a.png");
            // video2.setCreateTime(new Date());
            // video2.setPoint(9.70);
            // video2.setPrice(10);
            // video2.setSummary("这是专题课程");
            // List<Video> list = new ArrayList<>();
            // list.add(video1);
            // list.add(video2);
            // int rows = mapper.saveBatchVideo(list);
            // System.out.println(rows);
            // System.out.println(list.toString());

            // // todo: 全部更新 video
            // Video video = new Video();
            // video.setId(56);
            // video.setTitle("如何成为技术大牛");
            // video.setCoverImg("mr.yang.net/a1111.png");
            // video.setPoint(9.88);
            // video.setPrice(2222);
            // int rows = mapper.updateVideoById(video);
            // System.out.println(rows);
            // todo: 选择性更新 video 即没有填入的不会更新
            Video video = new Video();
            video.setId(56);
            video.setTitle("java从入门到放弃");
            video.setCoverImg("mr.yang.net/a1111.png");
            // video.setPoint(9.88);
            video.setPrice(77);
            int rows = mapper.updateVideoSelective(video);
            System.out.println(rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
