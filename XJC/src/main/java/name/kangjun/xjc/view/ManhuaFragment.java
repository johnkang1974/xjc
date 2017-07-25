package name.kangjun.xjc.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.kangjun.xjc.R;
import name.kangjun.xjc.adapter.ManhuaYizhourenqiAdapter;
import name.kangjun.xjc.base.BaseFragment;
import name.kangjun.xjc.httpUtils.RetrofitAPIManager;
import name.kangjun.xjc.httpUtils.RetrofitClient;
import name.kangjun.xjc.model.ManhuaBannerBean;
import name.kangjun.xjc.model.YizhourenqiBean;
import name.kangjun.xjc.model.YizhourenqiItemBean;
import name.kangjun.xjc.xjcApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManhuaFragment extends BaseFragment {
    private Context mContext;
    private LinearLayoutManager mYizhourenqiLLM;
    private ManhuaYizhourenqiAdapter mYizhourenqiAdpater;
    private GridLayoutManager mJingtiaoxixuanGLM;

    @BindView(R.id.banner_manhua)
    FlyBanner flyBanner;
    @BindView(R.id.yizhourenqi_recycler)
    RecyclerView mYizhourenqi_recycler;
    @BindView(R.id.jingtiaoxixuan_recycler)
    RecyclerView mJingtiaoxixuan_recycler;

    public ManhuaFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_manhua;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mContext = this.getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        getManhuaBanner();
        getYizhourenqiSection();
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 漫画轮播图
     */
    private void getManhuaBanner() {
        Call<ManhuaBannerBean> call = RetrofitAPIManager.provideClientApi().getManhuaBanner(
                "MainRecommend",
                "get_main_advertise",
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                xjcApplication.userID,
                0);
        call.enqueue(new Callback<ManhuaBannerBean>() {
            @Override
            public void onResponse(Call<ManhuaBannerBean> call, Response<ManhuaBannerBean> response) {
                try {
                    if (0 == response.body().getCode()) {
                        List<String> urls = new ArrayList<>();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            urls.add(response.body().getData().get(i).getCover());
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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ManhuaBannerBean> call, Throwable t) {
                Log.d("tag", t.getMessage());
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
            public void onResponse(Call<YizhourenqiBean> call, Response<YizhourenqiBean> response) {
                try {
                    if (0 == response.body().getCode()){
                        List<YizhourenqiItemBean> yizhourenqiItems = response.body().getData().getData();
                        mYizhourenqiLLM = new LinearLayoutManager(mContext);
                        mYizhourenqiLLM.setOrientation(LinearLayoutManager.HORIZONTAL);
                        mYizhourenqi_recycler.setLayoutManager(mYizhourenqiLLM);
                        mYizhourenqi_recycler.setHasFixedSize(true);
                        mYizhourenqiAdpater =new ManhuaYizhourenqiAdapter(yizhourenqiItems);
                        mYizhourenqi_recycler.setAdapter(mYizhourenqiAdpater);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<YizhourenqiBean> call, Throwable t) {

            }
        });
    }

}

