package com.example.todayinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView {

    //主要用于new出来的对象
    public FullScreenVideoView(Context context) {
        super(context);
    }

    //主要用于xml文件种,支持自定义属性
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //用于xml文件种,支持自定义属性，同时支持style样式
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //widthmeasureSpec：测量模式和测量大小
        //通过getDefaultSize来获取原始大小
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);

        setMeasuredDimension(width,height);
    }
}
