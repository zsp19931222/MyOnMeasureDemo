package com.zsp.myonmeasuredemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public class SimpleLayout extends ViewGroup {
    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //触发所有子View的onMeasure函数去测量宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //MeasureSpec封装了父View传递给子View的布局要求
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        int mWidth=0;
        int mHeight=0;
        switch (wMode) {
            case MeasureSpec.EXACTLY:
                mWidth = wSize;
                break;
            case MeasureSpec.AT_MOST:
                //这里应该先计算所有子view的宽度，暂时先写死
                mWidth = wSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        switch (hMode) {
            case MeasureSpec.EXACTLY:
                mHeight = hSize;
                break;
            case MeasureSpec.AT_MOST:
                //这里应该先计算所有子view的高度，暂时先写死
                mHeight = hSize;
                // mHeight = getCircleHeight() / 2 * 3;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        setMeasuredDimension(getChildAt(0).getMeasuredWidth()+30, getChildAt(0).getMeasuredHeight()+30);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        if (getChildCount() > 0) {
//            View childView = getChildAt(0);
//            View childView1 = getChildAt(1);
//            View childView2 = getChildAt(2);
//            Log.d(TAG, "onLayout: "+getWidth());
//            Log.d(TAG, "onLayout: "+childView.getWidth());
//            Log.d(TAG, "onLayout: "+childView.getMeasuredWidth());
//            childView.layout((getWidth()-childView.getMeasuredWidth())/2, (getHeight()-childView.getMeasuredHeight())/2, childView.getMeasuredWidth()+(getWidth()-childView.getMeasuredWidth())/2, childView.getMeasuredHeight()+(getHeight()-childView.getMeasuredHeight())/2);
//            childView1.layout( (getWidth()-childView1.getMeasuredWidth())/2, (getHeight()-childView1.getMeasuredHeight())/2,  childView1.getMeasuredWidth()+(getWidth()-childView1.getMeasuredWidth())/2, childView1.getMeasuredHeight()+(getHeight()-childView1.getMeasuredHeight())/2);
//            childView2.layout( (getWidth()-childView2.getMeasuredWidth())/2, (getHeight()-childView2.getMeasuredHeight())/2,  childView2.getMeasuredWidth()+(getWidth()-childView2.getMeasuredWidth())/2, childView2.getMeasuredHeight()+(getHeight()-childView2.getMeasuredHeight())/2);
//        }
        for (int i = 0; i <getChildCount() ; i++) {
            View childView = getChildAt(i);
            childView.layout((getWidth()-childView.getMeasuredWidth())/2, (getHeight()-childView.getMeasuredHeight())/2, childView.getMeasuredWidth()+(getWidth()-childView.getMeasuredWidth())/2, childView.getMeasuredHeight()+(getHeight()-childView.getMeasuredHeight())/2);
        }
    }

    private static final String TAG = "SimpleLayout";

}
