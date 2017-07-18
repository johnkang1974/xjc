package name.kangjun.xjc.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseFragment;
import name.kangjun.xjc.httpUtils.RetrofitAPIManager;
import name.kangjun.xjc.httpUtils.RetrofitClient;
import name.kangjun.xjc.model.ManhuaBannerBean;
import name.kangjun.xjc.xjcApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManhuaFragment extends BaseFragment {

    @BindView(R.id.banner_manhua)
    FlyBanner flyBanner;
    @BindView(R.id.yizhourenqi_content)
    HorizontalScrollView yizhourenqi_HorizontalScrollView;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        getManhuaBanner();
        initHorizontalScrollview();
        initScrollview();
        ButterKnife.bind(this,view);
        return view;
    }

    private void getManhuaBanner() {
        Call<ManhuaBannerBean> call = RetrofitAPIManager.provideClientApi().getManhuaBanner(
                RetrofitClient.MAINRECOMMEND,
                RetrofitClient.GET_MAIN_ADVERTISE,
                RetrofitClient.UI,
                RetrofitClient.UI_ID,
                xjcApplication.userID,
                0
        );
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

    private void initHorizontalScrollview() {
        for (int i = 0; i < 18; i++) {
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            ImageView imageview = new ImageView(this.getContext());
            imageview.setImageDrawable(drawable);
            linearLayout.addView(imageview);
        }
    }
    private void initScrollview() {
        for (int i = 0; i < 18; i++) {
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            ImageView imageview = new ImageView(this.getContext());
            imageview.setImageDrawable(drawable);
            linearLayout2.addView(imageview);
        }
    }
}

