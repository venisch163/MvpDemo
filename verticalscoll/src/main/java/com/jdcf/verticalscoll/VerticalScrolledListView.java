package com.jdcf.verticalscoll;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shenwenjie on 2018/2/8.
 */

public class VerticalScrolledListView extends LinearLayout {


    private static final String TAG = "VerticalScrolled";
    private Context mContext;
    private List<String> data = new ArrayList<String>();
    private int itemHeight = 0;

    public VerticalScrolledListView(Context context) {
        super(context);
        init(context);
    }

    public VerticalScrolledListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        mContext = context;
        setBackgroundColor(Color.parseColor("#11223344"));
        itemHeight = (int) context.getResources().getDimension(R.dimen.item_height);
        setPadding(0, 0, 0,  - DisplayUtils.dp2px(mContext, itemHeight));
        this.setOrientation(VERTICAL);
    }

    Handler mHandler = new Handler();
    Runnable mUpdateResults = () -> traversalView(VerticalScrolledListView.this);

    private void initTextView() {
        if (data != null && data.size() != 0) {
            for (int i = 0; i < data.size(); i++) {
                TextView textView = new TextView(mContext);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(25);
                textView.setBackgroundColor(Color.parseColor("#66117799"));
//                Drawable drawable = getResources().getDrawable(R.drawable.dianzan);
                Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.dianzan, null);;
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
                textView.setCompoundDrawablePadding(10);

                textView.setText(data.get(i));
                LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, itemHeight);
                this.addView(textView, layoutParams) ;
            }
            //初始化控件结束调用计时器
            startTimer();
        }
    }

    public void setData(List<String> data) {
        this.data = data;
        initTextView();
    }

    public void startTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //将数据源重新排序
                mHandler.post(mUpdateResults);
            }
        };
        timer.schedule(task, 0, 30);
    }

    public void traversalView(final ViewGroup viewGroup) {
        scrollBy(0, 2);
        computeScroll();
        int childCount = getChildCount();
        Log.d(TAG, "childCount>>>" + childCount);
        View view = getChildAt(0);
        int height = view.getHeight();
        Log.d(TAG, "height>>>" + height + "");
        Log.d(TAG, "getScrollX>>>" + getScrollY() + "");
        if (getScrollY() >= height) {
            removeView(view);
            addView(view);
            setScrollY(0);
        }
    }


}