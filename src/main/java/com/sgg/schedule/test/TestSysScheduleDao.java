package com.sgg.schedule.test;

import com.sgg.schedule.dao.SysScheduleDao;
import com.sgg.schedule.dao.imp.SysScheduleImpl;
import com.sgg.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/15:12
 * @Description:
 */
public class TestSysScheduleDao {
    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        sysScheduleDao=new SysScheduleImpl();
    }

    @Test
    public void testInsert() {
      int row=  sysScheduleDao.addSchedule(new SysSchedule(null,2,"学习数据库",0));
        System.out.println(row);
    }

    @Test
    public void testFindALL() {
        List<SysSchedule> allSchedule = sysScheduleDao.findAllSchedule();
        allSchedule.forEach(System.out::println);

    }
}
