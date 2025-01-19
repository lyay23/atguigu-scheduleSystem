package com.sgg.schedule.controller;

import com.sgg.schedule.pojo.SysUser;
import com.sgg.schedule.servlet.SysUserServlet;
import com.sgg.schedule.servlet.impl.SysUserServiceImpl;
import com.sgg.schedule.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/15:44
 * @Description:
 */
@WebServlet("/user/*")

public class SysUserController extends BaseController {
     private SysUserServlet userServlet = new SysUserServiceImpl();

    /**
     * 接收用户登录请求，完成登录业务的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("userPwd");

        //2.调用服务层的方法根据用户名查询用户信息
          SysUser loginUser= userServlet.findByUsername(username);
          if(null==loginUser){
              //跳转到用户名有误提示页面
              resp.sendRedirect("/loginUsernameError.html");
          } else if (!MD5Util.encrypt(password).equals(loginUser.getUserPwd())) {

              resp.sendRedirect("/loginUserPwdError.html");
          }else {
              //登录成功之后，将登录的用户信息放入session域里面
              HttpSession session = req.getSession();
              session.setAttribute("sysUser", loginUser);

             resp.sendRedirect("/showSchedule.html");
          }
        //3.判断密码是否匹配

        //4。成功！跳转到首页
    }


    /**
     * 接收用户注册请求的业务逻辑处理方法（业务处理接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //1.接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //2.调用服务层方法完成注册功能
       // 将参数放入一个SysUser对象中，在调用register方法时传入
        SysUser sysUser = new SysUser(null,username, userPwd);
        int rows= userServlet.register(sysUser);
        //3.根据注册结果做出页面跳转
        if(rows>0){
            resp.sendRedirect("/registerSuccess.html");
        }else {
            resp.sendRedirect("/registerFail.html");
        }
    }


}
