package com.myosetpaing.ecommercemvp.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import kotlinx.android.synthetic.main.view_item_history.view.*

class HistoryViewHolder(itemView: View) : BaseViewHolder<ProductVO>(itemView) {
    override fun setData(data: ProductVO) {
        Glide.with(itemView.context)
            .load(data.product_image_url!![0].image_url)
            .into(itemView.ivHistoryProduct)
        itemView.tvHistoryProductName.text = data.product_name
        itemView.tvHistoryProductDescription.text = data.product_desc
    }

}