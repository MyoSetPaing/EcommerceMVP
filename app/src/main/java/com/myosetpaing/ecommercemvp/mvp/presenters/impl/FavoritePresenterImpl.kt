package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.FavoriteDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.FavoritePresenter
import com.myosetpaing.ecommercemvp.mvp.views.FavoriteView

class FavoritePresenterImpl(val favoriteView: FavoriteView) : BasePresenterImpl(), FavoritePresenter {

    override fun onStart() {

    }


    override fun onStop() {
    }

    override fun onUIReady() {

        mFavoriteModel.getFavoriteModel(object : FavoriteDelegate {
            override fun onSuccess(favoriteProductList: List<ProductVO>) {
                favoriteView.showFavoriteList(favoriteProductList)

            }

            override fun emptyFavoriteList(msg: String) {
                favoriteView.showNoFavoriteList(msg)
            }

        })
    }

    override fun onTapProductItem(product: ProductVO) {
        favoriteView.showProductDetail(product.product_id)
    }

    override fun onTapFavorite(product: ProductVO) {
    }

    override fun onTapRemoveFavorite(product: ProductVO) {

    }


}