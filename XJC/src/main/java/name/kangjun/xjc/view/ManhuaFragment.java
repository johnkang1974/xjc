package name.kangjun.xjc.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.kangjun.xjc.R;
import name.kangjun.xjc.adapter.ManhuaHomeCommonItemAdapter;
import name.kangjun.xjc.adapter.ManhuaYizhourenqiAdapter;
import name.kangjun.xjc.base.BaseFragment;
import name.kangjun.xjc.httpUtils.RetrofitAPIManager;
import name.kangjun.xjc.httpUtils.RetrofitClient;
import name.kangjun.xjc.model.ManhuaBannerItemBean;
import name.kangjun.xjc.model.ManhuaHomeCommonBean;
import name.kangjun.xjc.model.ManhuaHomeCommonItemBean;
import name.kangjun.xjc.model.ManhuaBannerBean;
import name.kangjun.xjc.model.ManhuaSectionTitleBean;
import name.kangjun.xjc.model.ManhuaSectionTitleItemBean;
import name.kangjun.xjc.model.YizhourenqiBean;
import name.kangjun.xjc.model.YizhourenqiItemBean;
import name.kangjun.xjc.model.ZhuantiZhuanquBean;
import name.kangjun.xjc.model.ZhuantiZhuanquItemBean;
import name.kangjun.xjc.xjcApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManhuaFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private Context mContext;
    private LinearLayoutManager mYizhourenqiLLM;
    private ManhuaYizhourenqiAdapter mYizhourenqiAdpater;
    private TextView mArea1Title, mArea3Title, jingtiaoxixuanTitle, xinzuotuijianTitle, gangganggengxinTitle,
            mShuangkuaixiangTitle, mNvshengxiangTitle, mGaoxiaoTitle, mRimanTitle;
    private SimpleDraweeView mArea1Image, mArea2LeftImage, mArea2RightImage, mArea3Image,
            mArea4LeftImage, mArea4RightImage, mArea5Image;
    private RecyclerView mJingtiaoxixuan_recycler, mXinzuotuijian_recycler, mGangganggengxin_recycler,
            mShuangkuaixiang_recycler, mNvshengxiang_recycler, mGaoxiao_recycler, mRiman_recycler;
    private List<ManhuaSectionTitleItemBean> manhuaSectionTitleItemBean = null;


    @BindView(R.id.banner_manhua)
    FlyBanner flyBanner;
    @BindView(R.id.yizhourenqi_recycler)
    RecyclerView mYizhourenqi_recycler;
    @BindView(R.id.jingtiaoxixuan)
    View mJingtiaoxixuanView;
    @BindView(R.id.gangganggengxin)
    View mGangganggengxinView;
    @BindView(R.id.zhuanti_area1_manhua)
    View section1View;
    @BindView(R.id.zhuanti_area2_manhua)
    View section2View;
    @BindView(R.id.zhuanti_area3_manhua)
    View section3View;
    @BindView(R.id.zhuanti_area4_manhua)
    View section4View;
    @BindView(R.id.zhuanti_area5_manhua)
    View section5View;
    @BindView(R.id.xinzuotuijian_area_manhua)
    View xinzuuotuijianView;
    @BindView(R.id.shuangkuaixiang)
    View mShuangkuaixiangView;
    @BindView(R.id.nvshengxiang)
    View mNvshengxiangView;
    @BindView(R.id.gaoxiao)
    View mGaoxiaoView;
    @BindView(R.id.riman)
    View mRimanView;
    @BindView(R.id.swipeRefresh_manhua_home)
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this.getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = super.onCreateView(inflater, container, savedInstanceState);
        if (null != mView)
            ButterKnife.bind(this, mView);
        intiView();
        getDataFromDB();
        getDataFromNetwork();

        return mView;
    }

    private void getDataFromNetwork() {
        getManhuaBanner();              //轮播图
        getSectionTitle();              //获得各专区的title文字
        getYizhourenqiSection();        //一周人气
        getCommonSection(1, 3, 0);        //精挑细选
        getZhuantiZhuanquSection();     //拿专区和专题的信息
        getCommonSection(20, 3, 1);       //新作推荐
        getCommonSection(18, 3, 1);       //刚刚更新
        getCommonSection(21, 3, 1);       //爽快向
        getCommonSection(28, 3, 1);       //女生向
        getCommonSection(23, 3, 1);       //搞笑向
        getCommonSection(27, 3, 1);       //日漫
    }

    private void getDataFromDB() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_manhua;
    }

    /**
     * 漫画轮播图
     */
    private void getManhuaBanner() {
        Call<ManhuaBannerBean> manhuaBannerCall = RetrofitAPIManager.provideClientApi().get_main_advertise(
                "MainRecommend",
                "get_main_advertise",
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                xjcApplication.userID,
                0);
        manhuaBannerCall.enqueue(new Callback<ManhuaBannerBean>() {
            @Override
            public void onResponse(@NonNull Call<ManhuaBannerBean> call, @NonNull Response<ManhuaBannerBean> response) {
                ManhuaBannerBean manhuaBannerBean = response.body();
                if (null != manhuaBannerBean && 0 == manhuaBannerBean.getCode()) {
                    List<ManhuaBannerItemBean> manhuaBannerItemBeen = manhuaBannerBean.getData();
                    List<String> urls = new ArrayList<>();
                    for (int i = 0; i < manhuaBannerItemBeen.size(); i++) {
                        urls.add(manhuaBannerItemBeen.get(i).getCover());
                    }
                    flyBanner.setImagesUrl(urls);
                    flyBanner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            //进入其他的界面
                            // TODO: 2017/7/25
                            Log.d("onItemClick", "---->" + position);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<ManhuaBannerBean> call, @NonNull Throwable t) {

            }
        });

    }


    /***
     * 一周人气
     */
    private void getYizhourenqiSection() {
        Call<YizhourenqiBean> yizhourenqiCall = RetrofitAPIManager.provideClientApi().getManhuaYizhourenqi(
                "MainRank",
                "get_label_rank",
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                0,
                0,
                0,
                1,
                xjcApplication.userID);
        yizhourenqiCall.enqueue(new Callback<YizhourenqiBean>() {
            @Override
            public void onResponse(@NonNull Call<YizhourenqiBean> call, @NonNull Response<YizhourenqiBean> response) {
                YizhourenqiBean mYizhourenqiBean = response.body();
                if (null != mYizhourenqiBean && 0 == mYizhourenqiBean.getCode()) {
                    List<YizhourenqiItemBean> yizhourenqiItems = mYizhourenqiBean.getData().getData();
                    mYizhourenqiLLM = new LinearLayoutManager(mContext);
                    mYizhourenqiLLM.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mYizhourenqi_recycler.setLayoutManager(mYizhourenqiLLM);
                    mYizhourenqi_recycler.setHasFixedSize(true);
                    mYizhourenqiAdpater = new ManhuaYizhourenqiAdapter(mContext,yizhourenqiItems);
                    mYizhourenqi_recycler.setAdapter(mYizhourenqiAdpater);
                }
            }

            @Override
            public void onFailure(@NonNull Call<YizhourenqiBean> call, @NonNull Throwable t) {

            }
        });
    }


    /***
     * 拿专区和专题的信息
     * http://dajiaochong.517w.com/dacu_app/app/?c=MainRecommend&a=get_main_advertise&ui=0&ui_id=0&userid=0&type=3
     */
    private void getZhuantiZhuanquSection() {
        Call<ZhuantiZhuanquBean> zhuantiZhuanquBeanCall = RetrofitAPIManager.provideClientApi().getZhuantiZhuanqu(
                "MainRecommend",
                "get_main_advertise",
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                3,
                xjcApplication.userID);
        zhuantiZhuanquBeanCall.enqueue(new Callback<ZhuantiZhuanquBean>() {
            @Override
            public void onResponse(@NonNull Call<ZhuantiZhuanquBean> call, @NonNull Response<ZhuantiZhuanquBean> response) {
                ZhuantiZhuanquBean zhuantiZhuanquBean = response.body();
                if (null != zhuantiZhuanquBean && 0 == zhuantiZhuanquBean.getCode()) {
                    List<ZhuantiZhuanquItemBean> zhuantiZhuanquItems = zhuantiZhuanquBean.getData();
                    int advertise_type;
                    for (int i = 0; i < zhuantiZhuanquItems.size(); i++) {
                        advertise_type = Integer.parseInt(zhuantiZhuanquItems.get(i).getAdvertise_type());
                        switch (advertise_type) {
                            case 2:
                                mArea1Title.setText(zhuantiZhuanquItems.get(i).getTitle());
                                mArea1Image.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 3:
                                mArea2LeftImage.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 4:
                                mArea2RightImage.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 5:
                                mArea3Title.setText(zhuantiZhuanquItems.get(i).getTitle());
                                mArea3Image.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 6:
                                mArea4LeftImage.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 7:
                                mArea4RightImage.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                                break;
                            case 8:
                                mArea5Image.setImageURI(zhuantiZhuanquItems.get(i).getCover());
                            default:
                                break;
                        }
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<ZhuantiZhuanquBean> call, @NonNull Throwable t) {

            }
        });
    }


    /***
     * 获得各专区的Title文字
     * http://dajiaochong.517w.com/dacu_app/app/?c=LogicCommon&a=get_main_recommend_title&ui=0&ui_id=0&userid=0
     */
    private void getSectionTitle() {
        Call<ManhuaSectionTitleBean> manhuaSectionTitleBeanCall = RetrofitAPIManager.provideClientApi().get_main_recommend_title(
                "LogicCommon",
                "get_main_recommend_title",
                0,
                0,
                xjcApplication.userID);
        manhuaSectionTitleBeanCall.enqueue(new Callback<ManhuaSectionTitleBean>() {
            @Override
            public void onResponse(@NonNull Call<ManhuaSectionTitleBean> call, @NonNull Response<ManhuaSectionTitleBean> response) {
                ManhuaSectionTitleBean manhuaSectionTitleBean = response.body();
                if (null != manhuaSectionTitleBean && manhuaSectionTitleBean.getCode() == 0) {
                    manhuaSectionTitleItemBean = manhuaSectionTitleBean.getData();
                    int posid;
                    for (int i = 0; i < manhuaSectionTitleItemBean.size(); i++) {
                        posid = Integer.parseInt(manhuaSectionTitleItemBean.get(i).getPosid());
                        String strTitle = manhuaSectionTitleItemBean.get(i).getName();
                        switch (posid) {
                            case 1:
                                jingtiaoxixuanTitle.setText(strTitle);
                                break;
                            case 18:
                                gangganggengxinTitle.setText(strTitle);
                                break;
                            case 20:
                                xinzuotuijianTitle.setText(strTitle);
                                break;
                            case 21:
                                mShuangkuaixiangTitle.setText(strTitle);
                                break;
                            case 23:
                                mGaoxiaoTitle.setText(strTitle);
                                break;
                            case 27:
                                mRimanTitle.setText(strTitle);
                                break;
                            case 28:
                                mNvshengxiangTitle.setText(strTitle);
                                break;
                            default:
                                break;
                        }
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<ManhuaSectionTitleBean> call, @NonNull Throwable t) {

            }
        });
    }

    /***
     * 获取各个板块的漫画
     * @param type：板块ID
     * @param colums：一行几列
     * @param picStyle：0：横图  1：竖图
     */
    private void getCommonSection(final int type, final int colums, final int picStyle) {
        Call<ManhuaHomeCommonBean> nvshengxiangCall = RetrofitAPIManager.provideClientApi().get_main_recommend(
                "MainRecommend",
                "get_main_recommend",
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                type,
                0,
                xjcApplication.userID);
        nvshengxiangCall.enqueue(new Callback<ManhuaHomeCommonBean>() {
            @Override
            public void onResponse(@NonNull Call<ManhuaHomeCommonBean> call, @NonNull Response<ManhuaHomeCommonBean> response) {
                ManhuaHomeCommonBean commonBean = response.body();
                if (null != commonBean && 0 == commonBean.getCode()) {
                    List<ManhuaHomeCommonItemBean> commonItems = commonBean.getData().getData();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, colums){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }
                    };
                    gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                    ManhuaHomeCommonItemAdapter commonSectionAdapter = new ManhuaHomeCommonItemAdapter(commonItems, picStyle);
                    switch (type) {
                        case 1:
                            mJingtiaoxixuan_recycler.setLayoutManager(gridLayoutManager);
                            mJingtiaoxixuan_recycler.setHasFixedSize(true);
                            mJingtiaoxixuan_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 18:
                            mGangganggengxin_recycler.setLayoutManager(gridLayoutManager);
                            mGangganggengxin_recycler.setHasFixedSize(true);
                            mGangganggengxin_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 20:
                            mXinzuotuijian_recycler.setLayoutManager(gridLayoutManager);
                            mXinzuotuijian_recycler.setHasFixedSize(true);
                            mXinzuotuijian_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 21:
                            mShuangkuaixiang_recycler.setLayoutManager(gridLayoutManager);
                            mShuangkuaixiang_recycler.setHasFixedSize(true);
                            mShuangkuaixiang_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 23:
                            mGaoxiao_recycler.setLayoutManager(gridLayoutManager);
                            mGaoxiao_recycler.setHasFixedSize(true);
                            mGaoxiao_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 27:
                            mRiman_recycler.setLayoutManager(gridLayoutManager);
                            mRiman_recycler.setHasFixedSize(true);
                            mRiman_recycler.setAdapter(commonSectionAdapter);
                            break;
                        case 28:
                            mNvshengxiang_recycler.setLayoutManager(gridLayoutManager);
                            mNvshengxiang_recycler.setHasFixedSize(true);
                            mNvshengxiang_recycler.setAdapter(commonSectionAdapter);
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ManhuaHomeCommonBean> call, @NonNull Throwable t) {

            }
        });
    }


    private void intiView() {
        //精挑细选
        jingtiaoxixuanTitle = ButterKnife.findById(mJingtiaoxixuanView, R.id.title_TV);
        mJingtiaoxixuan_recycler = ButterKnife.findById(mJingtiaoxixuanView, R.id.content_recycler);

        mArea1Title = ButterKnife.findById(section1View, R.id.zhuanti_area_title);
        mArea1Image = ButterKnife.findById(section1View, R.id.image_zhuanti);
        mArea2LeftImage = ButterKnife.findById(section2View, R.id.left_image);
        mArea2RightImage = ButterKnife.findById(section2View, R.id.right_image);
        mArea3Title = ButterKnife.findById(section3View, R.id.zhuanti_area_title);
        mArea3Image = ButterKnife.findById(section3View, R.id.image_zhuanti);
        mArea4LeftImage = ButterKnife.findById(section4View, R.id.left_image);
        mArea4RightImage = ButterKnife.findById(section4View, R.id.right_image);
        mArea5Image = ButterKnife.findById(section5View, R.id.image_zhuanti);

        RelativeLayout mArea5RelativeLayout = ButterKnife.findById(section5View, R.id.section_title);
        mArea5RelativeLayout.setVisibility(View.GONE);

        //新作推荐
        xinzuotuijianTitle = ButterKnife.findById(xinzuuotuijianView, R.id.title_TV);
        mXinzuotuijian_recycler = ButterKnife.findById(xinzuuotuijianView, R.id.content_recycler);

        //刚刚更新
        gangganggengxinTitle = ButterKnife.findById(mGangganggengxinView, R.id.title_TV);
        mGangganggengxin_recycler = ButterKnife.findById(mGangganggengxinView, R.id.content_recycler);

        //爽快向
        mShuangkuaixiangTitle = ButterKnife.findById(mShuangkuaixiangView, R.id.title_TV);
        mShuangkuaixiang_recycler = ButterKnife.findById(mShuangkuaixiangView, R.id.content_recycler);

        //女生向
        mNvshengxiangTitle = ButterKnife.findById(mNvshengxiangView, R.id.title_TV);
        mNvshengxiang_recycler = ButterKnife.findById(mNvshengxiangView, R.id.content_recycler);

        //搞笑
        mGaoxiaoTitle = ButterKnife.findById(mGaoxiaoView, R.id.title_TV);
        mGaoxiao_recycler = ButterKnife.findById(mGaoxiaoView, R.id.content_recycler);

        //日漫
        mRimanTitle = ButterKnife.findById(mRimanView, R.id.title_TV);
        mRiman_recycler = ButterKnife.findById(mRimanView, R.id.content_recycler);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        getDataFromNetwork();
        swipeRefreshLayout.setRefreshing(false);
    }
}

