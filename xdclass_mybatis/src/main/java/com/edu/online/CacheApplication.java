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
public class CacheApplication {

    /**
     * mybaits 查询数据方式 先查二级缓存 然后查一级缓存 然后查询数据库
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String source = "config/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(source);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        try (SqlSession session = sessionFactory.openSession()) {
            VideoMapper mapper = session.getMapper(VideoMapper.class);
            /**
             *  mybatis 一级缓存 默认为开启状态
             *  ⼀级缓存的作⽤域是SQLSession，同⼀个SqlSession中执⾏相同的SQL查询(相同的
             * SQL和参数)，第⼀次会去查询数据库并写在缓存中，第⼆次会直接从缓存中取
             * 原理  Map key/value 存储
             */
            Video video1 = mapper.selectById(44);
            System.out.println(video1.toString());
            /**
             * 一级缓存的失效策略 当有数据发生 插入 更新 修改的时候 失效
             */
            // Video insertVideo = new Video();
            // insertVideo.setTitle("mr 杨 专题课程");
            // int rows = mapper.saveVideo(insertVideo);
            // System.out.println("影响行数~~"+rows);
            Video video2 = mapper.selectById(44);
            System.out.println(video2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * mybatis 二级缓存 作用域 namespaces
         * ⼆级缓存是namespace级别的，多个SqlSession去操作同⼀个namespace下的
         * Mapper的sql语句，多个SqlSession可以共⽤⼆级缓存,如果两个mapper的namespace相同
         *
         * 存储原理: 基于PerpetualCache 的 HashMap本地缓存，可⾃定义存储源
         *
         * 默认是没有开启⼆级缓存
         * 失效策略:执⾏同个namespace下的mapepr映射⽂件中增删改sql，并执⾏了commit操作,会清
         *  空该⼆级缓存
         *
         */
        // try {
        //     SqlSession session1 = sessionFactory.openSession();
        //     VideoMapper videoMapper1 = session1.getMapper(VideoMapper.class);
        //     Video video1 = videoMapper1.selectById(44);
        //     System.out.println(video1.toString());
        //
        //     // // 插入数据使二级缓存失效
        //     // Video insertVideo = new Video();
        //     // insertVideo.setTitle("mr 杨 专题课程");
        //     // int rows = videoMapper1.saveVideo(insertVideo);
        //     // System.out.println("影响行数~~" + rows);
        //     // session1.commit();
        //
        //     SqlSession session2 = sessionFactory.openSession();
        //     VideoMapper videoMapper2 = session2.getMapper(VideoMapper.class);
        //     Video video2 = videoMapper2.selectById(44);
        //     System.out.println(video2.toString());
        //     session2.commit();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }
}
