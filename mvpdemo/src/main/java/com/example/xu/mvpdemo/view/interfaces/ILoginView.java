package com.example.xu.mvpdemo.view.interfaces;

import com.example.xu.mvpdemo.model.LoginBean;

/**
 * Created by xu on 2017/6/27.
 */
public interface ILoginView {
    void showLoading();
    void hintLoading();
    void success(LoginBean loginBean);
    void faile();
    void error(String msg);
}
