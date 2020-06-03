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
public class TransactionApplication {

    /**
     *  前提数据库引擎为innodb 因为myisam 不支持事务
     * mybaits 事务管理方式分为两种
     * jdbc 默认事务管理 JdbcTransactionFactory -> JdbcTransaction
     * managed 表示 使用外部容器来管理事务 ManagedTransactionFactory -> ManagedTransaction
     * 如果没有外部容器 则事务不起作用
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String source = "config/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(source);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            // 当数据库事务为jdbc 时, sqlSession 默认事务为非自动提交
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
            Video video = new Video();
            video.setTitle("spring 5.x");
            videoMapper.saveVideo(video);
            // 模拟异常 造成数据回滚
            int i = 1 / 0;
            // 必须程序commit 不然不会保存到数据库中
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
        sqlSession.close();

    }
}
