package name.kangjun.xjc.httpUtils;

import name.kangjun.xjc.xjcApplication;

/**
 * Created by Kangjun on 2017/7/13.
 */

public class AssembleHttpHead {

    public static String AssembleUserAgent(xjcApplication context) {
        /**
         * 1、这里用String 就可以了，在固定字符串拼接下，String的效率高于StringBuilder
         * 2、不要单引号、双引号混用
         */
        String ua = "kidstone.cn" +
                "/" + context.getVersion() +//App版本名
                "/" + context.getCurVersionCode() +//App版本号
                "/" + "Android" +//手机系统平台
                "/" + android.os.Build.VERSION.RELEASE +//手机系统版本
                "/" + android.os.Build.MODEL + //手机型号
                "/" + context.getDeviceID() +//设备号
                "/" + context.getChannelID();
        //ua.append("/"+appContext.getAppId());//客户端唯一标识
        return ua;//渠道名
    }
}
