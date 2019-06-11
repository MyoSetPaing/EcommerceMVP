package com.myosetpaing.ecommercemvp.mvp.presenters

import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate

interface FavoritePresenter : BasePresenter, ProductItemDelegate {

    fun onUIReady()
}