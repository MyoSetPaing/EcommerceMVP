package com.myosetpaing.ecommercemvp.mvp.presenters

import com.myosetpaing.ecommercemvp.delegates.CategoryItemDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate

interface ProductPresenter : BasePresenter , CategoryItemDelegate,ProductItemDelegate{

    fun onUIReady()
    fun onTapFavoriteFab()

}