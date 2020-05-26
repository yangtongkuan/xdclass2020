package net.online.edu.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/25 20:59
 * @To change this template use File | Settings | File Templates.
 */
//@Component
public class CustomSchedule {

    /**
     * fixedRate : 定时多久执⾏⼀次（上⼀次开始执⾏时间点后xx秒再次执⾏；）
     * fixedDelay :  上⼀次执⾏结束时间点后xx秒再次执⾏
     * cron :  表达式 参考:https://tool.lu/crontab/
     */
//    @Scheduled(fixedRate = 2000)
    @Scheduled(cron = "*/1 * * * * *")
//    @Scheduled(fixedDelay = 2000)
    public void voidSchedule() throws InterruptedException {
        System.out.println(LocalDateTime.now() + "--->统计金额:" + Math.random());
        TimeUnit.SECONDS.sleep(1);
    }
}
