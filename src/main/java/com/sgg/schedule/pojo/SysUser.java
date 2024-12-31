package com.sgg.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * @Author: 李阳
 * @Date: 2024/12/30/10:35
 * @Description:User实体类
 * 1.实体类的类名和表格名称应该对应（对应不是一样）
 * 2.属性名和表格列名对应（可以不一致）
 * 3.属性私有，get和set
 * 4.无参构造器
 * 5.应该实现序列化接口（这是什么？）implements Serializable
 * 6.应该重写类的hashcode 和equals方法（学到了，后面使用集合的时候会用到）
 * 7.toString 可写可不写
 *
 *
 * 可以使用lombok帮助我们生成这些内容-get set equal hashcode 构造器
 *  lombok使用步骤
 *     1.安装依赖
 *     2.检查是否勾选 enable annotation processing
 *     3.添加注解 导入lombok的jar包
 */
@AllArgsConstructor//添加全参构造
@NoArgsConstructor//无参构造
@Data//get set equal hashcode
public class SysUser implements Serializable {

    private Integer uid;
    private String username;
    private String userPwd;


}
