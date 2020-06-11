package com.edu.online.interceptor;

import com.edu.online.utils.JWTUtils;
import com.edu.online.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 在执行请求之前,进行判断
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = request.getHeader("token");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("token");
        }
        try {
            Claims claims = JWTUtils.checkJWT(accessToken);
            if (claims != null) {
                Integer user_id = (Integer) claims.get("id");
                request.setAttribute("user_id", user_id);
                return true;
            }
        } catch (Exception e) {
        }
        sendJsonMessage(response, JsonData.buildError("登录失效,请重新登录"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * @param resp
     * @param obj
     */
    private void sendJsonMessage(HttpServletResponse resp, Object obj) {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        try (PrintWriter writer = resp.getWriter()) {
            ObjectMapper objectMapper = new ObjectMapper();
            writer.print(objectMapper.writeValueAsString(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static void sendJsonMessage(HttpServletResponse response, Object obj) {
    //     try {
    //         ObjectMapper objectMapper = new ObjectMapper();
    //         response.setContentType("application/json; charset=utf- 8");
    //         PrintWriter writer = response.getWriter();
    //         writer.print(objectMapper.writeValueAsString(obj));
    //         writer.close();
    //         response.flushBuffer();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
