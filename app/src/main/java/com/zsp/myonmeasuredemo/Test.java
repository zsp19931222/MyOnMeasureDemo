package com.zsp.myonmeasuredemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public class Test extends View {
    public Test(Context context) {
        super(context);
    }

    public Test(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {//控件宽度wrap_content得时候
            widthMeasureSpec=200;
        } else if (widthMode == MeasureSpec.EXACTLY) {//控件宽度为固定值或者match_parent得时候
            widthMeasureSpec=100;
        }
        if (heightMode == MeasureSpec.AT_MOST) {//控件高度wrap_content得时候
            heightMeasureSpec=300;
        } else if (heightMode == MeasureSpec.EXACTLY) {//控件高度为固定值或者match_parent得时候
            heightMeasureSpec=100;
        }
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    private static final String TAG = "Test";
}
