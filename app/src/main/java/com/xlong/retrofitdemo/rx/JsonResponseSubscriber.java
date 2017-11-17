package com.xlong.retrofitdemo.rx;


import com.xlong.retrofitdemo.base.IBaseView;
import com.xlong.retrofitdemo.exception.ApiException;
import com.xlong.retrofitdemo.vo.JsonResponse;

/**
 * Created by Administrator on 2017/1/12.
 */
public abstract class JsonResponseSubscriber<T> extends ResponseSubscriber<T> {

    public JsonResponseSubscriber(IBaseView baseView) {
        super(baseView);
    }

    @Override
    public void onNext(T t) {
        if (t instanceof JsonResponse) {
            JsonResponse response = (JsonResponse) t;
            if (JsonResponse.SUCCESS != response.getStatus()) {
                onError(new ApiException(response));
            }else{
                onSuccess(t);
            }
        }
    }

    public abstract void onSuccess(T t);
}
