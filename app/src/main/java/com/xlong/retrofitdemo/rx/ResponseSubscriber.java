package com.xlong.retrofitdemo.rx;


import com.orhanobut.logger.Logger;

import com.xlong.retrofitdemo.base.IBaseView;
import com.xlong.retrofitdemo.exception.ApiException;
import com.xlong.retrofitdemo.vo.JsonResponse;
import rx.Subscriber;

/**
 * RxJava 自定义Subscriber
 *
 * @param <T>
 * @author Hunter
 */
public abstract class ResponseSubscriber<T> extends Subscriber<T> {
    private static final String TAG = "ResponseSubscriber";
    private IBaseView mBaseView;
    // 是否显示加载进度条
    private boolean mIsShowLoading = true;

    public ResponseSubscriber(IBaseView baseView) {
        mBaseView = baseView;
    }

    public ResponseSubscriber(IBaseView baseView, boolean isShowLoading) {
        mBaseView = baseView;
        mIsShowLoading = isShowLoading;
    }

    @Override
    public void onStart() {
        if (mIsShowLoading) mBaseView.showProgress("正在加载...");
    }

    @Override
    public void onCompleted() {
        mBaseView.hideProgress();
    }

    @Override
    public void onError(Throwable e) {
        mBaseView.hideProgress();
        Logger.e(e.getMessage());
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;

            JsonResponse jsonResponse = apiException.getJsonResponse();

            if(jsonResponse.isTokenValid()){
                mBaseView.showToast("身份已过期");
                mBaseView.clearUser();
            }else{
                mBaseView.showToast(jsonResponse.getMessage());
            }

        }
    }
}
