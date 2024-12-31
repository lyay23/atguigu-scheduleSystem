package com.sgg.schedule.dao.imp;

import com.sgg.schedule.dao.BaseDao;
import com.sgg.schedule.dao.SysScheduleDao;
import com.sgg.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/11:19
 * @Description:
 */
public class SysScheduleImpl extends BaseDao implements SysScheduleDao {

    /**
     * 增加
     * @param
     * @return 返回受影响的行，成功就是1，不成功为0
     */
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql="insert into sys_schedule values(DEFAULT,?,?,?)";
       int row= baseUpdate(sql,schedule.getUid(),schedule.getTitle(),schedule.getComplete());
       return row;
    }

    @Override
    public List<SysSchedule> findAllSchedule() {
        String sql="select sid,uid,title,complete from sys_schedule";
        List<SysSchedule> schedules = baseQuery( SysSchedule.class,sql);

        return schedules;
    }


}
