package com.edu.online.sp.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

import java.time.LocalDate;

public class TimeHandlerAspect {


    public void beforeMethod() {
        System.out.println("before method time ->" + LocalDate.now());
    }


    public void afterMethod() {
        System.out.println("after method time ->" + LocalDate.now());
    }

    public void aroundMethod(ProceedingJoinPoint point) {
        Long startTime = System.currentTimeMillis();
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("接口请求时间:" + (System.currentTimeMillis() - startTime));
    }

}
