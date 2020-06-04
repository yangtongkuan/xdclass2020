package com.edu.online.sp;

import com.edu.online.sp.domain.Video;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Video video = (Video) applicationContext.getBean("video");
//        System.out.println(video.toString());
        // 依赖注入 spring通过动态注入  将video对象注入到videoOrder实例中
        // VideoOrder videoOrder = (VideoOrder) applicationContext.getBean("videoOrder");
        // System.out.println(videoOrder.toString());
        // System.out.println(videoOrder.getVideo().getTitle());

        // 依赖注入作用域
        // testInject(context);
        // 依赖注入的两种方式
        testInject2(context);
    }

    // 测试注入 - 作用域 scope
    public static void testInject(ApplicationContext context) {
        // bean的作用为singleton的情况下 spring只维护一个bean实例对象
        // 通过比较两个对象的内存地址 来判断是不是一个对象实例
        // Video video1 = (Video) context.getBean("video");
        // Video video2 = (Video) context.getBean("video");
        // System.out.println("scope singleton 获取对象为:" + (video1 == video2));
        // scope singleton 获取对象为:true

        Video video1 = (Video) context.getBean("video");
        Video video2 = (Video) context.getBean("video");
        System.out.println("scope prototype 获取对象为:" + (video1 == video2));
        // scope prototype 获取对象为:false
    }

    /**
     * spring的常⻅的注⼊⽅式
     * 1. 通过set方式注入
     * 2. 通过类构造器进行注入
     *
     * @param context
     */
    public static void testInject2(ApplicationContext context) {
        Video video2 = (Video) context.getBean("video2");
        System.out.println(video2.getTitle());
    }
}
