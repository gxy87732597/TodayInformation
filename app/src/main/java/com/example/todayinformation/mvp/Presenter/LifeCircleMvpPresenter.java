package com.example.todayinformation.mvp.Presenter;

import com.example.todayinformation.mvp.ILifeCircle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpControler;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    protected WeakReference<T> weakReference;

    public LifeCircleMvpPresenter(){
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);

        MvpControler mvpControler = iMvpView.getMvpControler();
        mvpControler.savaPresenter(this);
    }

    //P层数据同步
    @Override
    public void attachView(IMvpView iMvpView) {
        if(weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else{
            //如果这个弱引用是存在的，那么先获取出来
            T view = (T)weakReference.get();
            //如果这个弱引用和当前传递过来的对象不一致，那么就重新创建
            if(view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected  T getView(){
        T view;
       if(weakReference != null){
           view = (T) weakReference.get();
       }else{
           view = null;
       }

       if(view == null){
           return getEmptyView();
       }

       return view;
    }

    //子类去实现
    protected abstract T getEmptyView();

}
