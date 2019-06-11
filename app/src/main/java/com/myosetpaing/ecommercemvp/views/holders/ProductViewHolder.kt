package com.myosetpaing.ecommercemvp.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate
import kotlinx.android.synthetic.main.activity_product_detail.view.*
import kotlinx.android.synthetic.main.item_view_product.view.*

class ProductViewHolder(itemView: View, private val productItemDelegate: ProductItemDelegate) :
    BaseViewHolder<ProductVO>(itemView) {

    override fun setData(data: ProductVO) {
        Glide.with(itemView.context)
            .load(data.product_image_url?.get(0)?.image_url)
            .into(itemView.iv_product_image)

        itemView.tvProductName.text = data.product_name
        itemView.tv_product_price.text = data.product_price

        if (data.isFavorite == 0) {
            itemView.ivFavorite.visibility = View.GONE
            itemView.ivUnFavorite.visibility = View.VISIBLE
        } else {
            itemView.ivFavorite.visibility = View.VISIBLE
            itemView.ivUnFavorite.visibility = View.GONE
        }
        itemView.setOnClickListener {
            productItemDelegate.onTapProductItem(data)
        }
        itemView.ivFavorite.setOnClickListener {
            itemView.ivFavorite.visibility = View.GONE
            itemView.ivUnFavorite.visibility = View.VISIBLE
            productItemDelegate.onTapRemoveFavorite(data)
        }
        itemView.ivUnFavorite.setOnClickListener {
            itemView.ivFavorite.visibility = View.VISIBLE
            itemView.ivUnFavorite.visibility = View.GONE
            productItemDelegate.onTapFavorite(data)
        }

    }
}