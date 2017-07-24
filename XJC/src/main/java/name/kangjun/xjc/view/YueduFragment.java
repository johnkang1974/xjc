package name.kangjun.xjc.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.danxx.tabstrip.FlymeTabStrip;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseFragment;

/**
 * Created by Kangjun on 2017/6/13.
 */

public class YueduFragment extends BaseFragment {
    private Context mContext;
    private static final int NUMBER_TITLES = 3;
    private final String[] tabTitle = {"条 漫", "漫 画", "小 说"};

    private TiaomanFragment tiaomanFragment;
    private ManhuaFragment manhuaFragment;
    private XiaoshuoFragment xiaoshuoFragment;

    @BindView(R.id.content_viewpager_fragmentyuedu)
    ViewPager viewPager;
    @BindView(R.id.search_imagebutton_fragmentyuedu)
    ImageButton searchImgBtn;
    @BindView(R.id.sliding_tabs_fragmentyuedu)
    MagicIndicator menuTabStrip;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yuedu;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        assignView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void assignView() {
        PagerAdapter adapter = new myFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(NUMBER_TITLES);
        CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return NUMBER_TITLES;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {

                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(mContext);
                clipPagerTitleView.setText(tabTitle[i]);
                clipPagerTitleView.setPadding(30, 0, 30, 0);
                clipPagerTitleView.setTextColor(Color.WHITE);
                clipPagerTitleView.setClipColor(Resources.getSystem().getColor(android.R.color.holo_orange_dark));
                clipPagerTitleView.setAlpha(1.0f);
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(i);
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                WrapPagerIndicator indicator = new WrapPagerIndicator(context);
                indicator.setFillColor(Color.WHITE);
                return indicator;
            }
        });
        menuTabStrip.setNavigator(commonNavigator);
        ViewPagerHelper.bind(menuTabStrip, viewPager);
        searchImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "search is clicked...");
            }
        });
    }


    private class myFragmentPagerAdapter extends FragmentPagerAdapter {
        private myFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    if (tiaomanFragment == null) {
                        tiaomanFragment = new TiaomanFragment();
                    }
                    fragment = tiaomanFragment;
                    break;
                case 1:
                    if (manhuaFragment == null) {
                        manhuaFragment = new ManhuaFragment();
                    }
                    fragment = manhuaFragment;
                    break;
                case 2:
                    if (xiaoshuoFragment == null) {
                        xiaoshuoFragment = new XiaoshuoFragment();
                    }
                    fragment = xiaoshuoFragment;
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return NUMBER_TITLES;
        }
    }
}

