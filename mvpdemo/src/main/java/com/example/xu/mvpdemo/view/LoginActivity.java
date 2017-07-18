package com.example.xu.mvpdemo.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xu.mvpdemo.R;
import com.example.xu.mvpdemo.model.LoginBean;
import com.example.xu.mvpdemo.presenter.LoginPresenter;
import com.example.xu.mvpdemo.util.ShowToast;
import com.example.xu.mvpdemo.view.interfaces.ILoginView;
import com.wang.avi.AVLoadingIndicatorView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private Toolbar toolbar;
    private Button login_submit_btn;
    private EditText login_name_et, login_pwd_et;
    private LoginPresenter loginPresenter;
    private LoadingDialog loadingDialog;
    private TextView login_name_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 控件初始化
     */
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        login_submit_btn = (Button) findViewById(R.id.login_submit_btn);
        login_name_et = (EditText) findViewById(R.id.login_name_et);
        login_pwd_et = (EditText) findViewById(R.id.login_pwd_et);
        login_name_tv= (TextView) findViewById(R.id.login_name_tv);
        loginPresenter = new LoginPresenter(this);
    }

    public void submit(View view) {
        String name = login_name_et.getText().toString().trim();
        String pwd = login_pwd_et.getText().toString().trim();
        loginPresenter.login(name, pwd);
    }

    @Override
    public void showLoading() {
//        if(loading_avl.getVisibility()==View.GONE){
//            loading_avl.setVisibility(View.VISIBLE);
//        }
        loadingDialog = new LoadingDialog(this);
        loadingDialog.showDialog();
    }

    @Override
    public void hintLoading() {
        if (null != loadingDialog)
            loadingDialog.hideDialog();
    }

    @Override
    public void success(LoginBean loginBean) {
        //
        ShowToast.showToast(this, "恭喜登陆成功");
        login_name_tv.setText(loginBean.toString());
    }

    @Override
    public void faile() {
        ShowToast.showToast(this, "用户名或密码错误");
    }

    @Override
    public void error(String msg) {
        ShowToast.showToast(this, msg);
    }
}
