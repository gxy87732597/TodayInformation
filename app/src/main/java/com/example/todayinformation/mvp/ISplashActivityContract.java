package com.example.todayinformation.mvp;

public interface ISplashActivityContract {

    interface  Iview extends IMvpView{
        void setTvTimer(String timer);
    }

    interface  IPresenter extends ILifeCircle{
        void intiTimer();
    }

    Iview emptyView=new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }


        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
