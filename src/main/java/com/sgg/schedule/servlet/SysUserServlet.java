package com.sgg.schedule.servlet;

import com.sgg.schedule.pojo.SysUser;

/**
 * Created with IntelliJ IDEA.
 * @Author: 李阳
 * @Date: 2024/12/30/15:35
 * @Description:该接口定义了以Sys_User为核心的业务处理功能
 */
public interface SysUserServlet {
    /**
     * 注册用户的方法
     * @param sysUser，以sysUser对象的形式接收
     * @return 注册成功返回1，失败返回0
     */
    int register(SysUser sysUser);

    /**
     *根据用户名获得完整的用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了就返回SysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
