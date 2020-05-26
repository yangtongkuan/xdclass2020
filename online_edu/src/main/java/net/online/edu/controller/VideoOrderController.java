package net.online.edu.controller;

import net.online.edu.utils.JsonData;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/22 23:31
 * @To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {
    @PostMapping("/save")
    public JsonData saveOrder() {
        System.out.println("注册成功了~");
        System.out.println(1/0);
        return JsonData.buildSuccess("下单成功");
    }
}
