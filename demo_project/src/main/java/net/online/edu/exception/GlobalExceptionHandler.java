package net.online.edu.exception;

import net.online.edu.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonData handlerException(HttpServletRequest request, Exception e) {
        System.out.println(e.getMessage());
        return JsonData.buildError("系统故障~", -2);
    }

}
