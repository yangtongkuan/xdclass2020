package net.online.edu.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求监听器每个请求进来之后都会有监听和销毁
 */
// @WebListener
public class CustomHttpRequesterListener implements ServletRequestListener {
    private static ThreadLocal<Long> dataThreadLocal = new ThreadLocal<>();

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        System.out.println(dataThreadLocal.get());
        System.out.println("请求~:" + path + "; 毫秒数~" + (System.currentTimeMillis() - dataThreadLocal.get()));
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        dataThreadLocal.set(System.currentTimeMillis());
        System.out.println("请求开始时间~:" + System.currentTimeMillis());
    }
}
