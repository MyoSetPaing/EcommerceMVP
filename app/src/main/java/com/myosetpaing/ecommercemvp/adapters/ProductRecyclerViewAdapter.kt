package com.myosetpaing.ecommercemvp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate
import com.myosetpaing.ecommercemvp.views.holders.ProductViewHolder

class ProductRecyclerViewAdapter(val context: Context, private val productItemDelegate: ProductItemDelegate) :
    BaseRecyclerAdapter<ProductViewHolder, ProductVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_product, parent, false)
        return ProductViewHolder(itemView, productItemDelegate)
    }

}