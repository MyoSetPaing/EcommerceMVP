package com.myosetpaing.ecommercemvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.views.BaseView
import com.myosetpaing.ecommercemvp.views.holders.HistoryViewHolder

class HistoryRecyclerViewAdapter(val context: Context) : BaseRecyclerAdapter<HistoryViewHolder, ProductVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_history, parent, false)
        return HistoryViewHolder(view)
    }
}