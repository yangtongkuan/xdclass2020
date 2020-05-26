package com.edu.online;

import com.edu.online.domain.Video;
import com.edu.online.mapper.VideoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;

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
            List<Video> pointAndTitleLike = mapper.selectPointAndTitleLike(8.7, "HTML");
            System.out.println(pointAndTitleLike);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
