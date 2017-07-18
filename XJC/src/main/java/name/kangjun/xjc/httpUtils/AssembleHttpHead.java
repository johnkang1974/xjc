package name.kangjun.xjc.httpUtils;

import name.kangjun.xjc.xjcApplication;

/**
 *
 * Created by Kangjun on 2017/7/13.
 */

public class AssembleHttpHead {

    public static String AssembleUserAgent(xjcApplication context) {
        StringBuilder ua = new StringBuilder("kidstone.cn");
        ua.append('/' + context.getVersion());//App版本名
        ua.append('/' + "" + context.getCurVersionCode());//App版本号
        ua.append("/Android");//手机系统平台
        ua.append("/" + android.os.Build.VERSION.RELEASE);//手机系统版本
        ua.append("/" + android.os.Build.MODEL); //手机型号
        //ua.append("/"+appContext.getAppId());//客户端唯一标识
        ua.append("/" + context.getDeviceID());//设备号
        ua.append("/" + context.getChannelID());//渠道名
        return ua.toString();
    }


}
