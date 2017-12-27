package com.venisch.mvp.utils;

import android.util.SparseArray;
import android.view.View;

/**
 * 作者：guannan on 2016/7/27 09:54
 */
public class ViewHolderUtil {

    /**
     * ViewHolder的工具方法，简化代码
     * @param view
     * @param id
     * @param <T>
     * @return
     */
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
