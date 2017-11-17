package com.xlong.retrofitdemo.service;

import java.util.List;
import java.util.Map;

import com.xlong.retrofitdemo.app.URLs;
import com.xlong.retrofitdemo.vo.JsonResponse;
import com.xlong.retrofitdemo.vo.response.user.User;
import com.xlong.retrofitdemo.vo.response.user.UserInfo;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface UserService {

    /**
     * 用户签到
     *
     * @return
     */
    @POST(URLs.CUSTOMER + URLs.CUSTOMER_SIGNIN)
    Observable<JsonResponse> signin();

    /**
     * 用户登录
     *
     * @param requestParams
     * @return
     */
    @GET(URLs.LOGIN)
    Observable<JsonResponse<User>> login(@QueryMap Map<String, String> requestParams);

    /**
     * 用户注销
     *
     * @return
     */
    @PUT(URLs.LOGOFF)
    Observable<JsonResponse> logoff();

    /**
     * 用户注册
     *
     * @param requestParams
     * @return
     */
    @FormUrlEncoded
    @POST(URLs.REGISTER)
    Observable<JsonResponse> register(@FieldMap Map<String, String> requestParams);

    /**
     * 获取短信验证码
     *
     * @param requestParams
     * @return
     */
    @FormUrlEncoded
    @POST(URLs.MESSAGE + URLs.SEND_SMS)
    Observable<JsonResponse> sendMsg(@FieldMap Map<String, String> requestParams);
}
