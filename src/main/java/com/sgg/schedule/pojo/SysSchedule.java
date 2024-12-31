package com.sgg.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/11:02
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
       private Integer sid;
       private Integer uid;
       private String title;
       private Integer complete;
}
