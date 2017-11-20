package com.xlong.android.rx;


import com.xlong.android.vo.JsonResponse;
import com.xlong.android.exception.ApiException;

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
