package com.example.xu.mvpdemo.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.example.xu.mvpdemo.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by xu on 2017/6/27.
 */
public class LoadingDialog extends Dialog{

    private AVLoadingIndicatorView loading_avl;

    public LoadingDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        initView();
    }
    private void initView(){
        loading_avl= (AVLoadingIndicatorView) findViewById(R.id.loading_avl);
    }
    public void showDialog(){
        show();
        loading_avl.show();
    }
    public void hideDialog(){
        loading_avl.hide();
        dismiss();
    }
}
