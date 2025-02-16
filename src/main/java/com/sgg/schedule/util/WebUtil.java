package com.sgg.schedule.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2024/12/30/11:51
 * @Description:
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgg.schedule.common.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;


public class WebUtil {
    private static  ObjectMapper objectMapper;

    // 初始化objectMapper
    static {
        objectMapper = new ObjectMapper();
        // 设置JSON和Object转换时的时间日期格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    // 从请求中获取JSON串并转换为Object
    public static <T> T readJson(HttpServletRequest request, Class<T> clazz) {
        T t = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            t = objectMapper.readValue(buffer.toString(), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    // 将Result对象转换成JSON串并放入响应对象
    public static void writeJson(HttpServletResponse response, Result result) {
        response.setContentType("application/json;charset=UTF-8");
        try {
            String info = objectMapper.writeValueAsString(result);
            response.getWriter().write(info);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}