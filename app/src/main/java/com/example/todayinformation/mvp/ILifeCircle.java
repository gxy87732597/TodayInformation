package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

//接口
public interface ILifeCircle {
    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArguments);

    void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStrat();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destoryView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onSaveIndtanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);
}
