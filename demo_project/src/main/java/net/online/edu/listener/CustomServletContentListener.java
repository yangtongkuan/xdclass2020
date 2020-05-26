package net.online.edu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目启动监听器 可以用来加载一些数据
 */
@WebListener
public class CustomServletContentListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("==ServletContextListener====contextInitialized========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("==ServletContextListener====contextDestroyed========");
    }
}
