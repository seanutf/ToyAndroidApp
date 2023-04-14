package com.seanutf.learn.toyandroid.common;

import android.view.View;

import java.util.Calendar;

/**
 * @Desc 防止View连续点击
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {

    private long lastClickTime = 0;
    public static final int MIN_CLICK_DELAY_TIME = 600; //防止重复点击

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public abstract void onNoDoubleClick(View v);
}