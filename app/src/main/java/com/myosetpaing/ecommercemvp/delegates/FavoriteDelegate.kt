package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface FavoriteDelegate {

    fun onSuccess(favoriteProductList: List<ProductVO>)
    fun emptyFavoriteList(msg: String)
}
