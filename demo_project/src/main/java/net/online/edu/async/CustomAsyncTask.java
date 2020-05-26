package net.online.edu.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/25 21:41
 * @To change this template use File | Settings | File Templates.
 */
@Component
@Async
public class CustomAsyncTask {

    public void task1() {
        try {
            TimeUnit.MILLISECONDS.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task1");
    }

    public void task2() {
        try {
            TimeUnit.MILLISECONDS.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task2");
    }

    public void task3() {
        try {
            TimeUnit.MILLISECONDS.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task3");
    }

    public Future<String> task4() {
        try {
            TimeUnit.MILLISECONDS.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("test04");
    }

    public Future<String> task5() {
        try {
            TimeUnit.MILLISECONDS.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("test05");
    }

}
