package com.xlong.android.ui.interfaces.user;

import com.xlong.android.vo.response.user.UserInfo;
import com.xlong.android.base.IBaseView;

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
