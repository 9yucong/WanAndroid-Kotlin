package com.cong.wanandroid.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @Description:
 * @author: Cong.Gao
 * @date: 2022年05月13日
 */
class SpaceItemDecoration(private val height:Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = height;
        }
        outRect.bottom = height;
    }
}