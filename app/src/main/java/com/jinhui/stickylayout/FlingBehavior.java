package com.jinhui.stickylayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * 不加构造函数会出现报错异常：
 *  android.view.InflateException: Binary XML file line #15: Could not inflate Behavior subclass com.jinhui.stickylayout.FlingBehavior
 *     Caused by: java.lang.RuntimeException: Could not inflate Behavior subclass com.jinhui.stickylayout.FlingBehavior
 */
public class FlingBehavior extends AppBarLayout.Behavior {

    private boolean a;

    // 必须添加，不然不能解析控件
    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        if ((velocityY > 0.0f && !this.a) || (velocityY < 0.0f && this.a)){
            velocityY *= -1.0f;
        }
        if ((target instanceof RecyclerView) && velocityY < 0.0f){
            RecyclerView recyclerView = (RecyclerView) target;
            if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > 3){
                consumed = true;
            }else {
                consumed = false;
            }
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }


    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        this.a = dy > 0;
    }
}
