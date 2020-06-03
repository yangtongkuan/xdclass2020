package com.edu.online.sp;

import com.edu.online.sp.domain.Video;
import com.edu.online.sp.domain.VideoOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/6/3 22:43
 * @To change this template use File | Settings | File Templates.
 */
public class Application {

    public static void main(String[] args) {
        // 通过xml 创建spring管理容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Video video = (Video) applicationContext.getBean("video");
//        System.out.println(video.toString());
        // 依赖注入 spring通过动态注入  将video对象注入到videoOrder实例中
        VideoOrder videoOrder = (VideoOrder) applicationContext.getBean("videoOrder");
        System.out.println(videoOrder.toString());
        System.out.println(videoOrder.getVideo().getTitle());
    }
}
