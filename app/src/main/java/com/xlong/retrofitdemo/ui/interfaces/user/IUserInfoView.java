package com.xlong.retrofitdemo.ui.interfaces.user;

import com.xlong.retrofitdemo.base.IBaseView;
import com.xlong.retrofitdemo.vo.response.user.UserInfo;

/**
 * Created by Administrator on 2017/5/27.
 */

public interface IUserInfoView extends IBaseView {
    /**
     * 获取用户信息成功
     * @param userInfo
     */
    void uiUserInfo(UserInfo userInfo);
}
