package com.sgg.schedule.dao;
import com.sgg.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: 李阳
 * @Date: 2024/12/30/11:08
 * @Description:schedule的接口，定义规范
 */
public interface SysScheduleDao {
    /**
     * 该方法用于向数据库添加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类对象的方式入参
     * @return 返回受影响数据库记录的行数，行数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);

    /**
     * 查询用户所有信息
     * @return 将所有信息放到List集合中
     */
    List<SysSchedule> findAllSchedule();
}
