package com.example.xu.mvpdemo.model;

import android.text.TextUtils;

import com.example.xu.mvpdemo.model.LoginBean;
import com.example.xu.mvpdemo.model.interfaces.ILogin;
import com.example.xu.mvpdemo.model.interfaces.OnLoginListener;

/**
 * Created by xu on 2017/6/27.
 */
public class Login implements ILogin {
    private static final String NAME = "helloword";
    private static final String PWD = "123456";

    @Override
    public void login(final String name, final String pwd, final OnLoginListener onLoginListener) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                        sleep(2000);
                        if (NAME.equals(name) && PWD.equals(pwd)) {
                            //登陆成功
                            LoginBean loginBean = new LoginBean();
                            loginBean.setUserName(name);
                            loginBean.setPwd(pwd);
                            loginBean.setEmail("12345@qq.com");
                            loginBean.setSex("男");
                            loginBean.setTel("12345678901");
                            onLoginListener.success(loginBean);
                        } else {
                            //登陆失败  用户名或密码错误
                            onLoginListener.faile();
                        }
                    } else {
                        //用户名或密码为空
                        onLoginListener.error("用户名或密码为空");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
