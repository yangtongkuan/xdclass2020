package net.online.edu.controller;

import net.online.edu.async.CustomAsyncTask;
import net.online.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/25 21:43
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private CustomAsyncTask customAsyncTask;

    @GetMapping("/async")
    public JsonData testAsync() {
        long start = System.currentTimeMillis();
//        customAsyncTask.task1();
//        customAsyncTask.task2();
//        customAsyncTask.task3();
        Future<String> task4 = customAsyncTask.task4();
        Future<String> task5 = customAsyncTask.task5();
        for (; ; ) {
            if (task4.isDone() && task5.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        return JsonData.buildSuccess(end - start);
    }
}
