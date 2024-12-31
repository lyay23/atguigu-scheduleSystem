package com.sgg.schedule.dao.imp;

import com.sgg.schedule.dao.BaseDao;
import com.sgg.schedule.dao.SysUserDao;
import com.sgg.schedule.pojo.SysUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/11:19
 * @Description:
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql="insert into sys_user values(null,?,?)";
      return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());


    }

    @Override
    public SysUser findByUsernamae(String username) {
        String sql="select uid,username,user_pwd userPwd from sys_user where username=?";

        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);

         return sysUserList!=null&&sysUserList.size()>0?sysUserList.get(0):null;
    }
}
