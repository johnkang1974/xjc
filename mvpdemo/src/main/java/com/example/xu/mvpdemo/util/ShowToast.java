package com.example.xu.mvpdemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xu on 2017/6/27.
 */
public class ShowToast {
    public static void showToast(Context context,String string){
        if(null!=string){
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
        }
    }
}
