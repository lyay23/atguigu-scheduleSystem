package com.sgg.schedule.common;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李阳
 * @Date: 2025/01/19/21:03
 * @Description:状态码的枚举类
 */
public enum ResultCodeEnum {
   SUCCEED (200,"success"),
   USERNAME_ERROR (501,"usernameError"),
   PASSWORD_ERROR (503,"passwordError"),
   NOTLOGIN (504,"notLogin"),
   USERNAME_USED (505,"usernameUsed");



    private Integer code;//状态码
    private String message;//状态码的含义
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
