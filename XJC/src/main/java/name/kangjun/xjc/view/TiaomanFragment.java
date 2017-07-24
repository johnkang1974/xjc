package name.kangjun.xjc.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.PrivateKey;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.kangjun.xjc.R;
import name.kangjun.xjc.adapter.TiaomanHomeAdapter;
import name.kangjun.xjc.base.BaseFragment;
import name.kangjun.xjc.httpUtils.RetrofitAPIManager;
import name.kangjun.xjc.httpUtils.RetrofitClient;
import name.kangjun.xjc.model.TiaomanHomeBean;
import name.kangjun.xjc.model.TiaomanHomeItemBean;
import name.kangjun.xjc.model.TiaomanHomeListBean;
import name.kangjun.xjc.xjcApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiaomanFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private final static String TAG = "TiaomanFragment";
    private final static int LOADING = 0;
    private final static int NOMORE = 1;
    private int lastVisibleItem;

    @BindView(R.id.tiaoman_home_recyclerView)
    RecyclerView tiaoman_home_recyclerView;
    @BindView(R.id.tiaoman_home_swiperefreshlayout)
    SwipeRefreshLayout tiaoman_home_swipeRefreshLayout;

    LinearLayoutManager mLinearLayoutManager;
    List<TiaomanHomeItemBean> mTiaomanHomeItems;
    TiaomanHomeListBean tiaomanHomeListModel;
    TiaomanHomeAdapter mAdapter;
    int itemStart = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (null != view) {
            ButterKnife.bind(this, view);
        }
        initView();
        getTiaomanList(itemStart);
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tiaoman;
    }


    private void initView() {
        mLinearLayoutManager = new LinearLayoutManager(this.getContext());
        tiaoman_home_recyclerView.setLayoutManager(mLinearLayoutManager);
        tiaoman_home_recyclerView.setHasFixedSize(true);
        mAdapter = new TiaomanHomeAdapter(getActivity());
        tiaoman_home_recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == mAdapter.getItemCount() - 1) {
                    getTiaomanList(itemStart);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
            }
        });

        tiaoman_home_swipeRefreshLayout.setOnRefreshListener(this);
        tiaoman_home_recyclerView.setAdapter(mAdapter);
    }

    private void getTiaomanList(final int intStart) {

        Call<TiaomanHomeBean> call = RetrofitAPIManager.provideClientApi()
                .getTiaomanList(
                        RetrofitClient.MAINRECOMMEND,
                        RetrofitClient.GET_TIAOMAN_RECOMMEND,
                        RetrofitClient.UI,
                        RetrofitClient.UI_ID,
                        xjcApplication.userID,
                        intStart);
        call.enqueue(new Callback<TiaomanHomeBean>() {
                         @Override
                         //从网上拿条漫列表数据
                         public void onResponse(Call<TiaomanHomeBean> call, Response<TiaomanHomeBean> response) {
                             if (0 == response.body().getCode()) {
                                 String strCDN = response.body().getData().getCdn();
                                 TiaomanHomeAdapter.setStrCDN(strCDN);
                                 if (!(response.body().getData().getEnd()).equals("0")) {    //表示没有后续的
                                     tiaomanHomeListModel = response.body().getData();
                                     mTiaomanHomeItems = tiaomanHomeListModel.getData();
                                     if (null != mTiaomanHomeItems && mTiaomanHomeItems.size() != 0) {
                                         if (intStart == 0) {       //第一次拿
                                             mAdapter.addData(mTiaomanHomeItems);
                                         } else {                   //不是第一次拿
                                             mAdapter.addMoreData(mTiaomanHomeItems);
                                             //footRefresh显示加载ing
                                             mAdapter.showFootRefresh(true);
                                         }
                                         try {
                                             itemStart = Integer.parseInt(response.body().getData().getEnd());
                                         } catch (NumberFormatException e) {
                                             itemStart = 0;
                                             e.printStackTrace();
                                         }
                                     }
                                     tiaoman_home_swipeRefreshLayout.setRefreshing(false);
                                 } else {
                                     //footRefresh显示没有更多
                                     mAdapter.showFootRefresh(false);
                                 }
                             }
                         }

                         @Override
                         public void onFailure(Call<TiaomanHomeBean> call, Throwable t) {
                             Log.d("tag", t.getMessage());
                         }
                     }
        );
    }

    @Override
    public void onRefresh() {
        getTiaomanList(0);      //下拉刷新从第一页开始拿数据
    }

}
