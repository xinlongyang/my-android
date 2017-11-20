package com.xlong.android.rx;


import com.xlong.android.base.IBaseView;
import com.xlong.android.exception.ApiException;
import com.xlong.android.vo.JsonResponse;

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
