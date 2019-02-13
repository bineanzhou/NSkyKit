package com.nsky.kit.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * <p>可以禁止滑动翻页的ViewPager </p>
 *
 * @version V1.1
 * @name NoScrollViewPager
 */
public class NoScrollViewPager extends ViewPager {

    private boolean isPagingEnabled = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    public void setPagerEnabled(boolean b) {
        this.isPagingEnabled = b;
    }

}
