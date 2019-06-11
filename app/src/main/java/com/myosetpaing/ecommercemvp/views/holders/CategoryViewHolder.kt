package com.myosetpaing.ecommercemvp.views.holders

import android.view.View
import com.bumptech.glide.Glide
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.delegates.CategoryItemDelegate
import kotlinx.android.synthetic.main.item_view_category.view.*

class CategoryViewHolder(itemView: View, private val categoryItemDelegate: CategoryItemDelegate):BaseViewHolder<CategoryVO>(itemView){

    override fun setData(data: CategoryVO) {
        mData=data
        Glide.with(itemView.context)
            .load(data.category_icon)
            .into(itemView.iv_category_item )
        itemView.tv_category_item.text=data.category_name

        itemView.setOnClickListener {
            categoryItemDelegate.onTapCategoryItem(data)

        }

    }

}