package com.myosetpaing.ecommercemvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.delegates.CategoryItemDelegate
import com.myosetpaing.ecommercemvp.views.holders.CategoryViewHolder

class CategoryRecyclerViewAdapter(val context: Context, private val mDelegate: CategoryItemDelegate): BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_category, parent, false)
        return CategoryViewHolder(itemView,mDelegate)
    }

}