package com.sgg.schedule.servlet.impl;

import com.sgg.schedule.dao.SysUserDao;
import com.sgg.schedule.dao.imp.SysUserDaoImpl;
import com.sgg.schedule.pojo.SysUser;
import com.sgg.schedule.servlet.SysUserServlet;
import com.sgg.schedule.util.MD5Util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/15:38
 * @Description:
 */
public class SysUserServiceImpl implements SysUserServlet {
    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int register(SysUser sysUser) {

        //将sysUser的密码转换为密文密码
//        String userPwd = sysUser.getUserPwd();
//        String encrypt = MD5Util.encrypt(userPwd);
//        sysUser.setUserPwd(encrypt);

        //代码等价
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //调用dao层的代码，将sysUser的信息存入数据库

//        int rows = userDao.addSysUser(sysUser);
//        return rows;
        //等价于

        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
      SysUser sysUser=  userDao.findByUsernamae(username);
      return sysUser;
    }
}
