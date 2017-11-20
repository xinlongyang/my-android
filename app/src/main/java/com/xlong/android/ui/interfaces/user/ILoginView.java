package com.xlong.android.ui.interfaces.user;

import com.xlong.android.base.IBaseView;
import com.xlong.android.vo.response.user.User;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface ILoginView extends IBaseView {
    /**
     * 登录成功
     * @param user
     */
    void uiLogin(User user);
}
