package name.kangjun.xjc;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;

import com.facebook.drawee.backends.pipeline.Fresco;

import name.kangjun.xjc.httpUtils.AssembleHttpHead;

/**
 *
 * Created by Kangjun on 2017/7/13.
 */

public class xjcApplication extends Application {
    public static String strUserAgent = "";
    public static int userID = 44664;
    public xjcApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        strUserAgent = AssembleHttpHead.AssembleUserAgent(this);
    }


    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Cann't get version name.";
        }
    }

    /**
     * 获取version code
     *
     * @return 当前应用的版本号
     */
    public String getCurVersionCode() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            return info.versionCode + "";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 获取设备号
     *
     * @return String android_id
     */
    public String getDeviceID() {
        String androidId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidId;
    }

    /***
     * 获取渠道号
     * @return String 渠道ID
     */
    public String getChannelID() {
        try {
//            ApplicationInfo appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
//            return appInfo.packageName;
            return "kidstone";
        } catch (Exception e) {
            e.printStackTrace();
            return "Can't got channel ID.";
        }
    }

}
