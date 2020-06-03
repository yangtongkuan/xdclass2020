package com.edu.online;

import com.edu.online.domain.VideoOrder;
import com.edu.online.mapper.VideoOrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/26 21:34
 * @To change this template use File | Settings | File Templates.
 */
public class LazyApplication {

    public static void main(String[] args) throws IOException {
        String source = "config/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(source);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        try (SqlSession session = sessionFactory.openSession()) {
            VideoOrderMapper videoOrderMapper = session.getMapper(VideoOrderMapper.class);

            /**
             * 懒加载 也是按需加载
             *  步骤 : 必选全局开启懒加载功能 参考mybatis-config.xml文件
             * 例如 查询个所有的订单 订单中存在用户信息  如果不查看用户的信息的话不会查询用户信息
             *      只有查看用户信息的时候才会查询数据库或者缓存
             */
            List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderListLazy();
            for (VideoOrder videoOrder : videoOrderList) {
                System.out.println(videoOrder.getVideoTitle());
            }
            System.out.println(videoOrderList.get(0).getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
