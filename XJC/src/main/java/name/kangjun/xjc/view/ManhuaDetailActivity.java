package name.kangjun.xjc.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseActivity;

public class ManhuaDetailActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_manhua_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPageName("ManhuaDetailActivity");

    }


}
