package name.kangjun.xjc.view;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import butterknife.BindView;
import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseActivity;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private YueduFragment yueduFragment;
    private ShoucangFragment shoucangFragment;
    private QuanziFragment quanziFragment;
    private WodeFragment wodeFragment;

    private FragmentManager fm;
    private android.support.v4.app.FragmentTransaction ft;
    private Fragment upFragment;
    private Fragment nextFragment;

    @BindView(R.id.rg_tabbar_tabbarlayout)
    RadioGroup mTabbarActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPageName("MainActivity");
        mTabbarActivityMain.setOnCheckedChangeListener(this);
        MainActivity.setWindowStatusBarColor(this,android.R.color.holo_orange_dark);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        yueduFragment = new YueduFragment();
        nextFragment = yueduFragment;
        ft.add(R.id.content_framelayout_activity_main, yueduFragment).commitAllowingStateLoss();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (checkedId) {
            case R.id.rbtn_manhua_tabbarlayout:
                if (yueduFragment == null) {
                    yueduFragment = new YueduFragment();
                }
                upFragment = nextFragment;
                nextFragment = yueduFragment;
                fragmentManager();
                break;
            case R.id.rbtn_collect_tabbarlayout:
                if (shoucangFragment == null) {
                    shoucangFragment = new ShoucangFragment();
                }
                upFragment = nextFragment;
                nextFragment = shoucangFragment;
                fragmentManager();
                break;
            case R.id.rbtn_square_tabbarlayout:
                if (quanziFragment == null) {
                    quanziFragment = new QuanziFragment();
                }
                upFragment = nextFragment;
                nextFragment = quanziFragment;
                fragmentManager();
                break;
            case R.id.rbtn_mine_tabbarlayout:
                if (wodeFragment == null) {
                    wodeFragment = new WodeFragment();
                }
                upFragment = nextFragment;
                nextFragment = wodeFragment;
                fragmentManager();
                break;
            default:
                break;
        }
    }

    private void fragmentManager() {
        if (nextFragment.isAdded()) {
            ft.hide(upFragment).show(nextFragment).commitAllowingStateLoss();
        } else {
            if (null != upFragment) {
                ft.hide(upFragment).add(R.id.content_framelayout_activity_main, nextFragment).commitAllowingStateLoss();
            } else {
                ft.add(R.id.content_framelayout_activity_main, nextFragment).commitAllowingStateLoss();
            }
        }
    }
}
