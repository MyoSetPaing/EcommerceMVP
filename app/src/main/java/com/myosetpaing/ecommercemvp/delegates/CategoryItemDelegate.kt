package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.CategoryVO

interface CategoryItemDelegate {

    fun onTapCategoryItem(category: CategoryVO)
}