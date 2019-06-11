package com.myosetpaing.ecommercemvp

import android.graphics.Rect
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class BottomOffsetDecoration(var bottomOffset: Int) : androidx.recyclerview.widget.RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: androidx.recyclerview.widget.RecyclerView, state: androidx.recyclerview.widget.RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val dataSize = state.itemCount
        val position = parent.getChildAdapterPosition(view)
        if (parent.layoutManager is androidx.recyclerview.widget.GridLayoutManager) {
            val grid = parent.layoutManager as androidx.recyclerview.widget.GridLayoutManager
            val spanCount = 2 //grid.spanCount
            if (dataSize - position < spanCount) {
                outRect.set(0, 0, 0, bottomOffset)
            } else {
                outRect.set(0, 0, 0, 0)
            }
        } else {
            if (dataSize > 0 && position == dataSize - 1) {
                outRect.set(0, 0, 0, bottomOffset)
            } else {
                outRect.set(0, 0, 0, 0)
            }
        }
    }
}