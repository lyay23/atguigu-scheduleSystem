package com.sgg.schedule.dao;

import com.sgg.schedule.pojo.SysUser;

/**
 * Created with IntelliJ IDEA.
 * @Author: 李阳
 * @Date: 2024/12/30/11:06
 * @Description:数据访问对象
 * 该类中用于定义针对表格的CRUD的方法（增删改查）
 * dao层一般需要定义接口和实现类
 */
public interface SysUserDao {

    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username和user_pwd字段以SysUser实体类对象的形式接收
     * @return 成功1失败0
     */
    int addSysUser(SysUser sysUser);

    /**
     *根据用户名获得完整的用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了就返回SysUser对象，找不到返回null
     */
    SysUser findByUsernamae(String username);
}
