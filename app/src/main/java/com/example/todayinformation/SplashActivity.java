package com.example.todayinformation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView mVideoView;
    private TextView tv_splash_timer;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = findViewById(R.id.vv_play);

        mVideoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+ File.separator+ R.raw.splash));

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });


        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        tv_splash_timer = findViewById(R.id.tv_splash_timer);
        tv_splash_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandle() {
            @Override
            public void onTicker(int time) {
                tv_splash_timer.setText(time+"秒");
            }

            @Override
            public void onFinish() {
                tv_splash_timer.setText("跳过");
            }
        });

        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
