package com.myosetpaing.ecommercemvp.mvp.views

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface FavoriteView: BaseView {
    fun showFavoriteList(favoriteList: List<ProductVO>)
    fun showNoFavoriteList(msg: String)
    fun showProductDetail(productId: Int)

}