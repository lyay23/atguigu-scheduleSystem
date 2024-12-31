package com.sgg.schedule.test;

import com.sgg.schedule.dao.BaseDao;
import com.sgg.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/13:28
 * @Description:
 */
public class TestBase {
   private static BaseDao baseDao ;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }


  @Test
   public void testBase(){
        //查询用户数量 baseDao.baseQueryObject单行单列的
        String sql = "select count(1) from sys_user";
       Long count= baseDao.baseQueryObject(sql);
       System.out.println(count);

    }
   @Test
    public void testBaseQuery(){
        //查询多行
        String sql = "select uid ,username,user_pwd userPwd from sys_user";
        List<Object> objects = baseDao.baseQuery(SysUser.class, sql);
        objects.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?) ";
      int rows = baseDao.baseUpdate(sql,1,"学习java",0);
        System.out.println(rows);
    }
}
