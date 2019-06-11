package com.myosetpaing.ecommercemvp.views.holders

import androidx.recyclerview.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<W : Any>(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView){

    protected lateinit var mData: W


    abstract fun setData(data: W)
}