package com.myosetpaing.ecommercemvp.mvp.presenters

import com.myosetpaing.ecommercemvp.activities.BaseActivity
import com.myosetpaing.ecommercemvp.delegates.CategoryItemDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate

interface ProductPresenter :   CategoryItemDelegate,ProductItemDelegate{

    fun onUIReady(activity: BaseActivity)
    fun onTapFavoriteFab()

}