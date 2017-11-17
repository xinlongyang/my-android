package com.xlong.retrofitdemo.app;

/**
 * URL路径处理类
 *
 * @author Hunter
 */
public class URLs {
    public static final String BASE_URL = "http://host:port/xxx/api/v1/";

    /**
     * 用户模块
     */
    public static final String CUSTOMER = "customer/";
    // 用户签到
    public static final String CUSTOMER_SIGNIN = "signin";
    // 登录
    public static final String LOGIN = "login";
    // 注销
    public static final String LOGOFF = "logoff";
    // 注册
    public static final String REGISTER = "register";
    // 获取/更新用户信息
    public static final String CUSTOMER_INFO = "info";

    /**
     * 短信模块
     */
    public static final String MESSAGE = "message/";
    // 获取短信验证码
    public static final String SEND_SMS = "sms";
}
