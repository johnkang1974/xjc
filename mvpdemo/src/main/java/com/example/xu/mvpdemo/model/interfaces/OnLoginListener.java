package com.example.xu.mvpdemo.model.interfaces;

import com.example.xu.mvpdemo.model.LoginBean;

/**
 * Created by xu on 2017/6/27.
 */
public interface OnLoginListener {
    void success(LoginBean loginBean);
    void faile();
    void error(String msg);
}
