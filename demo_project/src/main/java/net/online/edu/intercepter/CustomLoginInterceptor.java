package net.online.edu.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.online.edu.domain.User;
import net.online.edu.service.UserService;
import net.online.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义登录拦截器
 */
public class CustomLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /**
     * 在controller 之前执行 所以将登录拦截下载这里
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===CustomLoginInterceptor===preHandle===");
        // header 取值
        String token = request.getHeader("token");
        // 路径
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        // 入参
        if (StringUtils.isEmpty(token)) {
            String[] tokens = request.getParameterValues("token");
            if (tokens != null && tokens.length > 0) {
                token = tokens[0];
            }
        }
        if (!StringUtils.isEmpty(token)) {
            User user = userService.getUserByToken(token);
            if (user != null) {
                return true;
            } else {
                JsonData jsonData = JsonData.buildError("登录失效,请重新登录", -2);
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(jsonData);
                writeJson(response, json);
                return false;
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登录", -3);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(jsonData);
            writeJson(response, json);
            return false;
        }
    }

    /**
     * 在controller 之后执行 controller异常后不会执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===CustomLoginInterceptor===postHandle===");
    }

    /**
     * 在controller 之后执行 controller异常后也会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===CustomLoginInterceptor===afterCompletion===");
    }

    //
    // json data
    private void writeJson(HttpServletResponse res, String json) {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        try (PrintWriter writer = res.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
