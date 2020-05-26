package net.online.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/18 21:08
 * @To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableAsync
public class OnlineEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEduApplication.class, args);
    }
}
