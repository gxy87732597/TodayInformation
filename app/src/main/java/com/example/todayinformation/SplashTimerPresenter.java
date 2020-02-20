package com.example.todayinformation;
import com.example.todayinformation.mvp.ISplashActivityContract;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }

    @Override
    public void intiTimer() {

        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandle() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time+"秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");

            }
        });

        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
        //Log.e("SplashTimerPresenter", "onDestroy" );
    }

    //防止空指针
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

}
