package com.myosetpaing.ecommercemvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate
import com.myosetpaing.ecommercemvp.views.holders.FavoriteViewHolder

class FavoriteRecyclerViewAdapter(private val productItemDelegate: ProductItemDelegate) :
    BaseRecyclerAdapter<FavoriteViewHolder, ProductVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_favorite, parent, false)
        return FavoriteViewHolder(view, productItemDelegate)
    }

}