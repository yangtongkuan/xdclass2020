package net.online.edu.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.online.edu.domain.User;
import net.online.edu.service.UserService;
import net.online.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/5/22 23:34
 * @To change this template use File | Settings | File Templates.
 */
// @WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Autowired
    private UserService userService;

    // 项目启动时执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init login filter   ===== ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        // header 取值
        String token = req.getHeader("token");
        // 路径
        if (StringUtils.isEmpty(token)) {
            token = req.getParameter("token");
        }
        // 入参
        if (StringUtils.isEmpty(token)) {
            String[] tokens = req.getParameterValues("token");
            if (tokens != null && tokens.length > 0) {
                token = tokens[0];
            }
        }
        if (!StringUtils.isEmpty(token)) {
            User user = userService.getUserByToken(token);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                JsonData jsonData = JsonData.buildError("登录失效,请重新登录", -2);
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(jsonData);
                writeJson(res, json);
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登录", -3);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(jsonData);
            writeJson(res, json);
        }
    }

    // 项目stop时执行
    @Override
    public void destroy() {
        System.out.println("destroy login filter   ===== ");
    }

    // jsondata
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
