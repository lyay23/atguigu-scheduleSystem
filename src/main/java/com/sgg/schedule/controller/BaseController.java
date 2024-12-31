package com.sgg.schedule.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/16:14
 * @Description:
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断请求是增删改查的哪一种
        String requestURI = req.getRequestURI();//拿到的就是 /schedule/add
        String[] split = requestURI.split("/");
        String method = split[split.length - 1];

        //通过反射 通过方法名获取方法
        Class aClass = this.getClass();
        //获取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //设置暴力破解方法的访问修饰符
            declaredMethod.setAccessible(true);
            //执行方法
            declaredMethod.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
