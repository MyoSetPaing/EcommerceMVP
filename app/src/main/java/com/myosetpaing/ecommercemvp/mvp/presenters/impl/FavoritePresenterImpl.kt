package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.model.FavoriteModel
import com.myosetpaing.ecommercemvp.data.model.FavoriteModelImpl
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.FavoriteDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.FavoritePresenter
import com.myosetpaing.ecommercemvp.mvp.views.FavoriteView

class FavoritePresenterImpl: BasePresenterImpl<FavoriteView>(), FavoritePresenter {
    private val mFavoriteModel: FavoriteModel = FavoriteModelImpl


    override fun onUIReady() {

        mFavoriteModel.getFavoriteModel(object : FavoriteDelegate {
            override fun onSuccess(favoriteProductList: List<ProductVO>) {
                mView.showFavoriteList(favoriteProductList)

            }

            override fun emptyFavoriteList(msg: String) {
                mView.showNoFavoriteList(msg)
            }

        })
    }

    override fun onTapProductItem(product: ProductVO) {
        mView.showProductDetail(product.product_id)
    }

    override fun onTapFavorite(product: ProductVO) {
    }

    override fun onTapRemoveFavorite(product: ProductVO) {

    }


}