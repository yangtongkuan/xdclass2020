package com.edu.online.sp.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * Created with IntelliJ IDEA.
 * todo: bean 实例创建后的二次加工
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/6/4 20:26
 * @To change this template use File | Settings | File Templates.
 */
public class CustomBeanPostProcessor2 implements BeanPostProcessor,Ordered {


    /**
     * 执行过程
     * video 空构造器执行了~~
     *  CustomBeanPostProcessor postProcessBeforeInitialization beanName = video
     * video init~~~~
     *  CustomBeanPostProcessor postProcessAfterInitialization beanName = video
     *  1. 类构造器 -> 2.postProcessBeforeInitialization -> 3.类init初始化方法 -> 4.postProcessAfterInitialization
     *
     */

    /**
     * 在bean初始化之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" CustomBeanPostProcessor2 postProcessBeforeInitialization beanName = " + beanName);
        return bean;
    }

    /**
     * 在bean初始化之后进行执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" CustomBeanPostProcessor2 postProcessAfterInitialization beanName = " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
