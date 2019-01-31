package com.jdcf.verticalscoll;

import android.content.Context;

/**
 * Created by shenwenjie on 2018/2/8.
 */

public class DisplayUtils {
    /**
     *
     * @param context 上下文
     * @param values dp值
     * @return
     */
    public static int dp2px(Context context, int values) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (values * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
