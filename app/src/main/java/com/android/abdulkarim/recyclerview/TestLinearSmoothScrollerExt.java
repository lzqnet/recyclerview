package com.android.abdulkarim.recyclerview;

import android.content.Context;
import com.zhiqing.recyclerview_lib.recyclerview.widget.LinearSmoothScroller;

public class TestLinearSmoothScrollerExt extends LinearSmoothScroller {
    private int mPadding;
    public TestLinearSmoothScrollerExt(Context context) {
        super(context);
    }
    public void setFitPadding(int padding){
        mPadding=padding;
    }

    @Override
    public int calculateDtToFit(int viewStart,
                                int viewEnd,
                                int boxStart,
                                int boxEnd,
                                int snapPreference) {
        if (viewStart < boxStart) {//view从上往下移动 view在 recyclerview 头部以上 返回正值
            return boxStart - viewStart + mPadding;
        } else if (viewStart > boxStart) {//view从下往上移动 view在recycler底部以下 返回负值
            return mPadding + boxStart - viewStart;
        } else {//返回正值
            return mPadding;
        }
    }

    @Override
    protected int getVerticalSnapPreference() {
        return SNAP_TO_START;
    }
}
