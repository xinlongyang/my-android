package com.xlong.android.ui.interfaces.user;

import com.xlong.android.base.IBaseView;

/**
 * Created by Administrator on 2017/5/5.
 */

public interface IVerifCodeView extends IBaseView {
    /**
     * 发送验证码成功
     */
    void uiVerifCode();

    /**
     * 获取验证码失败
     */
    void failVerifCode();
}
