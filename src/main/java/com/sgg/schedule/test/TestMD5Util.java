package com.sgg.schedule.test;

import com.sgg.schedule.util.MD5Util;
import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/17:11
 * @Description:
 */
public class TestMD5Util {

    @Test
    public void testMD5() {
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
