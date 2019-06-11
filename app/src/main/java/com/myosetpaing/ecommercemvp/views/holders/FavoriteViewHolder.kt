package com.myosetpaing.ecommercemvp.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.view_item_favorite.view.*

class FavoriteViewHolder(itemView: View, val productItemDelegate: ProductItemDelegate) :
    BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context)
            .load(data.product_image_url!![0].image_url)
            .into(itemView.ivFavoriteImage)
        itemView.setOnClickListener {
            productItemDelegate.onTapProductItem(data)
        }
    }


}