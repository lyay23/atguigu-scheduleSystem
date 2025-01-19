package com.sgg.schedule.filter;

import com.sgg.schedule.pojo.SysUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/01/19/15:06
 * @Description:过滤器，未登录不能访问日程表
 */
@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       //参数父转子
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //获得session域对象
        HttpSession session = request.getSession();
        //从session域中获取登录的用户对象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");

        //判断用户对象是否未空，
        if (sysUser == null) {
            //未登录-到login.html
            response.sendRedirect("/login.html");
        }else {
            //登录过就放行
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
