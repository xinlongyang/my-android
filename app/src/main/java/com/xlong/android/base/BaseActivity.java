package com.xlong.android.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

import com.xlong.android.app.UserManager;
import com.xlong.android.app.ActivityManager;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Activity基类
 *
 * @author Hunter
 */
public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private Toast toast;
    private ProgressDialog mProgressDialog;

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化控制中心
     */
    public abstract void initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResId());
        // 初始化View注入
        ButterKnife.bind(this);
        initPresenter();
        initView();

        ActivityManager.getInstance().pushActivity(this);
    }

    protected abstract int getContentResId();

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void finish() {
        super.finish();
        ActivityManager.getInstance().popActivity(this);
    }

    @Override
    public void showProgress(final boolean flag, final String message) {

    }

    @Override
    public void showProgress(String message) {
        showProgress(true, message);
    }

    @Override
    public void showProgress(int strRes) {
        showProgress(getString(strRes));
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            if (toast == null) {
                toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }

            toast.show();
        }
    }

    @Override
    public void showToast(int res) {
        showToast(getString(res));
    }

    @Override
    public void openPage(Class clazz) {
        openPage(new Intent(this, clazz));
    }

    @Override
    public void openPage(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void openPageForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void close() {
        finish();
    }

    /**
     * 开始执行一个异步任务
     *
     * @param observable
     * @param subscriber
     * @param <T>
     */
    @Override
    public <T> void startAsync(Observable<T> observable, Subscriber<T> subscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<T>bind())
                .subscribe(subscriber);
    }

    @Override
    public void clearUser() {
        UserManager.getInstance().clearUserInfo();
    }

    @Override
    public <T> LifecycleTransformer<T> bind() {
        return bindToLifecycle();
    }
}
