package name.kangjun.xjc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.danxx.tabstrip.FlymeTabStrip;

import butterknife.BindView;
import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseFragment;

/**
 * Created by Kangjun on 2017/6/13.
 */

public class YueduFragment extends BaseFragment {
    private TiaomanFragment tiaomanFragment;
    private ManhuaFragment manhuaFragment;
    private XiaoshuoFragment xiaoshuoFragment;
    private myFragmentPagerAdapter adapter;
    private View view;

    @BindView(R.id.content_viewpager_fragmentyuedu)
    ViewPager viewPager;
    @BindView(R.id.search_imagebutton_fragmentyuedu)
    ImageButton searchImgBtn;
    @BindView(R.id.sliding_tabs_fragmentyuedu)
    FlymeTabStrip menuTabStrip;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yuedu;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        assignView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void assignView() {
        adapter = new myFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(myFragmentPagerAdapter.NUMBER_TITLES);
        menuTabStrip.setViewPager(viewPager);
        searchImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "search is clicked...");
            }
        });
    }

    private class myFragmentPagerAdapter extends FragmentPagerAdapter {
        private static final int NUMBER_TITLES = 3;
        private final String[] tabTitle = {"条 漫", "漫 画", "小 说"};

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
