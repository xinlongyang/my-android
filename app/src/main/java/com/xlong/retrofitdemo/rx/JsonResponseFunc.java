package com.xlong.retrofitdemo.rx;


import com.xlong.retrofitdemo.exception.ApiException;
import com.xlong.retrofitdemo.vo.JsonResponse;
import rx.functions.Func1;

/**
 * RxJava map转换
 *
 * @param <T>
 * @author Hunter
 */
public class JsonResponseFunc<T> implements Func1<JsonResponse<T>, T> {
    @Override
    public T call(JsonResponse<T> tJsonResponse) {
        if (tJsonResponse == null) return null;

        if (tJsonResponse.getStatus() != JsonResponse.SUCCESS) {
            throw new ApiException(tJsonResponse);
        }

        return tJsonResponse.getData();
    }
}
