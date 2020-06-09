package com.edu.online.exception;

import com.edu.online.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public JsonData handler(Exception e) {
        log.error("[全局异常]:{}", e);

        if (e instanceof XDException) {
            return JsonData.buildError(((XDException) e).getCode(), ((XDException) e).getMsg());
        } else {
            return JsonData.buildError("全局异常,未知的系统错误");
        }
    }
}
