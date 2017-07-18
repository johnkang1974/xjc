package name.kangjun.xjc.interfaces;

import name.kangjun.xjc.model.ManhuaBannerBean;
import name.kangjun.xjc.model.TiaomanHomeBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * Created by Kangjun on 2017/7/10.
 */

public interface HttpService {

    /**
     * 条漫首页获取列表
     * http://dajiaochong.517w.com/dacu_app/app/?c=MainRecommend&a=get_tiaoman_recommend&ui=0&ui_id=0&userid=0&start=0
     */
    @GET("app/")
    Call<TiaomanHomeBean> getTiaomanList(@Query("c") String paramC,
                                         @Query("a") String paramA,
                                         @Query("ui") int ui,
                                         @Query("ui_id") int ui_id,
                                         @Query("userid") int userID,
                                         @Query("start") int start);

    /***
     * 漫画首页获取轮播图
     * http://dajiaochong.517w.com/dacu_app/app/?c=MainRecommend&a=get_main_advertise&ui=0&ui_id=0&userid=0&type=0
     */
    @GET("app/")
    Call<ManhuaBannerBean> getManhuaBanner(@Query("c") String paramC,
                                           @Query("a") String paramA,
                                           @Query("ui") int ui,
                                           @Query("ui_id") int ui_id,
                                           @Query("userid") int userID,
                                           @Query("type") int type);
}
