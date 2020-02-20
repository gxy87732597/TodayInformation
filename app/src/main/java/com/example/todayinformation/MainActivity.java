package com.example.todayinformation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.fab_main_home)
    FloatingActionButton fabMainHome;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    RadioButton hangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rb_main_nav_home_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_car_source_shenzhen)
    RadioButton rbMainCarSourceShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        changeAnima(rgMainBottom,rgMainTop);
    }

    private boolean isChangTopOrBottom;
    @OnClick(R.id.fab_main_home)
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.fab_main_home:
                isChangTopOrBottom = !isChangTopOrBottom;
                if(isChangTopOrBottom){
                    changeAnima(rgMainTop,rgMainBottom);
                }else{
                    changeAnima(rgMainBottom,rgMainTop);
                }

                break;
        }
    }

    private void changeAnima(RadioGroup gone,RadioGroup show) {

        //消失动画
        gone.clearAnimation();   //清除动画
        Animation animationGone = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        //显示动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this,R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);

    }
}
