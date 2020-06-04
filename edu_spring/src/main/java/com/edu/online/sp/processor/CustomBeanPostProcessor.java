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
public class CustomBeanPostProcessor implements BeanPostProcessor,Ordered {

    /**
     * autowire 注解的底层实现就是使用了BeanPostProcessor接口 对象后置处理器
     */
    /**
     *BeanPostProcessor 接口 是spring ioc 提供的一个扩展接口
     * 在调⽤初始化⽅法前后对 Bean 进⾏额外加⼯，ApplicationContext 会⾃动扫描实现了
     * BeanPostProcessor的 bean，并注册这些 bean 为后置处理器
     *
     * Ordered 提供getOrder方法返回整数  来调整执行循序 越小优先级越高
     */

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
        System.out.println(" CustomBeanPostProcessor postProcessBeforeInitialization beanName = " + beanName);
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
        System.out.println(" CustomBeanPostProcessor postProcessAfterInitialization beanName = " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
