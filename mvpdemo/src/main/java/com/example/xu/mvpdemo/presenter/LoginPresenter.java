package com.example.xu.mvpdemo.presenter;

import com.example.xu.mvpdemo.model.Login;
import com.example.xu.mvpdemo.model.LoginBean;
import com.example.xu.mvpdemo.model.interfaces.ILogin;
import com.example.xu.mvpdemo.model.interfaces.OnLoginListener;
import com.example.xu.mvpdemo.view.interfaces.ILoginView;

import android.os.Handler;

/**
 * Created by xu on 2017/6/27.
 */
public class LoginPresenter {
    private ILogin iLogin;
    private ILoginView iLoginView;
    private OnLoginListener onLoginListener;
    private Handler mHandler;

    public LoginPresenter(ILoginView iLoginView) {
        iLogin = new Login();
        this.iLoginView = iLoginView;
        mHandler = new Handler();
    }

    public void login(String name, String pwd) {
        iLoginView.showLoading();
        iLogin.login(name, pwd, new OnLoginListener() {
            @Override
            public void success(final LoginBean loginBean) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hintLoading();
                        iLoginView.success(loginBean);
                    }
                });
            }

            @Override
            public void faile() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hintLoading();
                        iLoginView.faile();
                    }
                });
            }

            @Override
            public void error(final String msg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iLoginView.hintLoading();
                        iLoginView.error(msg);
                    }
                });
            }
        });
    }
}
