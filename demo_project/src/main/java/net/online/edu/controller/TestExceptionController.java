package net.online.edu.controller;

import net.online.edu.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class TestExceptionController {

    @RequestMapping("/exception")
    public JsonData testException() {
        int re = 1 / 0;
        return JsonData.buildSuccess(null);
    }

}
