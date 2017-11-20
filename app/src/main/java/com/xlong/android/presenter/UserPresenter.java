package com.xlong.android.presenter;

import com.xlong.android.base.BasePresenter;
import com.xlong.android.rx.ResponseSubscriber;
import com.xlong.android.service.UserService;
import com.xlong.android.ui.interfaces.user.ILogoffView;
import com.xlong.android.ui.interfaces.user.IRegisterView;
import com.xlong.android.vo.JsonResponse;
import com.xlong.android.vo.UserPwd;
import com.xlong.android.vo.request.RegisterRequest;
import com.xlong.android.ui.interfaces.user.ILoginView;
import com.xlong.android.ui.interfaces.user.ISignView;
import com.xlong.android.rx.JsonResponseSubscriber;
import com.xlong.android.ui.interfaces.user.ISendMsgView;
import com.xlong.android.utils.CommonUtils;
import com.xlong.android.vo.request.LoginRequest;
import com.xlong.android.vo.request.SendMsgRequest;
import com.xlong.android.vo.response.user.User;

/**
 * Created by Administrator on 2017/1/4.
 */
public class UserPresenter extends BasePresenter {
    UserService service;

    @Override
    protected void initService() {
        service = getService(UserService.class);
    }


    /**
     * 用户签到
     *
     * @param signView
     */
    public void signin(final ISignView signView) {
        subscribe(signView, service.signin(), new JsonResponseSubscriber<JsonResponse>(signView) {
            @Override
            public void onSuccess(JsonResponse response) {
                signView.uiSign();
            }
        });
    }

    /**
     * 用户登录
     *
     * @param loginView
     * @param userPwd
     */
    public void login(final ILoginView loginView, UserPwd userPwd) {
        //todo 请求参数校验

        LoginRequest request = new LoginRequest();
        request.setMobile(userPwd.getMobile());
        request.setPassword(CommonUtils.EncryptMD5(userPwd.getPwd()));

        subscribe(loginView, convertResponse(service.login(converParams(request))), new ResponseSubscriber<User>(loginView) {
            @Override
            public void onNext(User user) {
                loginView.uiLogin(user);
            }
        });
    }

    /**
     * 用户注册
     *
     * @param registerView
     * @param userPwd
     */
    public void register(final IRegisterView registerView, UserPwd userPwd) {
        //todo 请求参数校验

        RegisterRequest request = new RegisterRequest();
        request.setMobile(userPwd.getMobile());
        request.setCaptcha(userPwd.getCaptcha());
        request.setPassword(CommonUtils.EncryptMD5(userPwd.getPwd()));

        subscribe(registerView, service.register(converParams(request)), new JsonResponseSubscriber<JsonResponse>(registerView) {
            @Override
            public void onSuccess(JsonResponse response) {
                registerView.uiRegister();
            }
        });
    }

    /**
     * 用户注销
     *
     * @param logoffView
     */
    public void logoff(final ILogoffView logoffView) {
        subscribe(logoffView, service.logoff(), new JsonResponseSubscriber<JsonResponse>(logoffView) {
            @Override
            public void onSuccess(JsonResponse response) {
                logoffView.uiLogoff();
            }
        });
    }

    /**
     * 获取短信验证码
     *
     * @param sendMsgView
     * @param request
     */
    public void sendMsg(final ISendMsgView sendMsgView, SendMsgRequest request) {
        //todo 请求参数校验

        subscribe(sendMsgView, service.sendMsg(converParams(request)), new JsonResponseSubscriber<JsonResponse>(sendMsgView) {
            @Override
            public void onSuccess(JsonResponse response) {
                sendMsgView.uiSendMsg();
            }
        });
    }


}
