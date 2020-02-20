package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpControler implements ILifeCircle{

    //存P层的实例
    private Set<ILifeCircle> lifeCircles = new HashSet<>();

    public void savaPresenter(ILifeCircle iLifeCircle){
        this.lifeCircles.add(iLifeCircle);
    }

    public static MvpControler mewInstance(){
        return  new MvpControler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> iterator = this.lifeCircles.iterator();
        while(iterator.hasNext()){
            ILifeCircle next = iterator.next();
            if(intent == null){
                intent=new Intent();
            }

            if (getArguments == null){
                getArguments=new Bundle();
            }

            next.onCreate(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCircle> var3 = this.lifeCircles.iterator();
        while(var3.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var3.next();
            if(intent == null){
                intent=new Intent();
            }

            if (getArguments == null){
                getArguments=new Bundle();
            }

            presenter.onActivityCreated(savedInstanceState,intent,getArguments);
        }

    }

    @Override
    public void onStrat() {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.onStrat();
        }
    }

    @Override
    public void onResume() {

        Iterator var2=this.lifeCircles.iterator();
        while(var2.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var2.next();
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.onDestroy();
        }
        this.lifeCircles.clear();
    }

    @Override
    public void destoryView() {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.destoryView();
        }
    }

    @Override
    public void onViewDestroy() {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {

        Iterator var2=this.lifeCircles.iterator();
        while(var2.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var2.next();
            presenter.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Iterator var4=this.lifeCircles.iterator();
        while(var4.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var4.next();
            presenter.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveIndtanceState(Bundle outState) {

        Iterator var2=this.lifeCircles.iterator();
        while(var2.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var2.next();
            presenter.onSaveIndtanceState(outState);
        }
    }

    @Override
    public void attachView(IMvpView iMvpView) {

        Iterator var1=this.lifeCircles.iterator();
        while(var1.hasNext()){
            ILifeCircle presenter = (ILifeCircle)var1.next();
            presenter.attachView(iMvpView);
        }
    }
}
