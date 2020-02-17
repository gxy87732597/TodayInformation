package com.example.todayinformation;

import android.os.Handler;


public class CustomCountDownTimer implements Runnable{
    private int time;
    private final ICountDownHandle countDownHandler;
    private boolean isRun;
    private int countDownTime;
    private final Handler handler;

    //设计者模式
    //实时去回调，倒计时几秒
    //动态传入总时间
    //每过一秒，总秒数减一
    //当倒计时为0时，要回调完成的状态

    public CustomCountDownTimer(int time,ICountDownHandle countDownHandle){

        handler = new Handler();

        this.time= time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandle;

    }

    //开启倒计时
    public void start(){
        isRun=true;
        handler.post(this);
    }

    //中止回调
    public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }

    //实现具体逻辑
    @Override
    public void run() {
        if(isRun){
            if(countDownHandler != null){
                countDownHandler.onTicker(countDownTime);
            }
        }

        if(countDownTime ==0){
            cancel();
            if(countDownHandler != null){
                countDownHandler.onFinish();
            }
        }else{
            countDownTime = time--;
            handler.postDelayed(this,1000);
        }
    }

    //定义接口：观察组织回调接口
    public interface ICountDownHandle{
        //倒计时回调
        void onTicker(int time);

        //完成回调
        void onFinish();
    }

}
