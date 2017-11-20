package com.xlong.android.ui.interfaces.user;

import com.xlong.android.base.IBaseView;
import com.xlong.android.vo.response.user.User;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface IForgetView extends IBaseView {
    /**
     * 找回密码
     * @param user
     */
    void uiForget(User user);
}
