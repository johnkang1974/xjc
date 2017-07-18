package com.example.xu.mvpdemo.model.interfaces;

/**
 * Created by xu on 2017/6/27.
 */
public interface ILogin {
    void login(String name,String pwd,OnLoginListener onLoginListener);
}
