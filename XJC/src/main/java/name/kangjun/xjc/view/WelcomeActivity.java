package name.kangjun.xjc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import name.kangjun.xjc.R;
import name.kangjun.xjc.base.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class WelcomeActivity extends BaseActivity {
    private static final int ANIM_TIME = 3000;
    private static final float SCALE_END = 1.2F;

    @BindView(R.id.chongniang_image_launch_screen)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPageName("WelcomeAcitivity");
        imageView.setImageResource(R.mipmap.iv_loading_chongniang);

        Observable.timer(1000, java.util.concurrent.TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startAnim();
                    }
                });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    private void startAnim(){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, SCALE_END);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }
        });
    }
}
