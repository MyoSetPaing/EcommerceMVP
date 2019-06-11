package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductDetailDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductDetailPresenter
import com.myosetpaing.ecommercemvp.mvp.views.ProductDetailView

class ProductDetailPresenterImpl(val productDetailView: ProductDetailView) : BasePresenterImpl(),
    ProductDetailPresenter {


    override fun onUIReady(productId: Int) {

        mProductModel.getProductDetail(productId, object : ProductDetailDelegate {
            override fun onSuccess(product: ProductVO) {
                productDetailView.showProductDetail(product)
            }

        })

    }


    override fun onStart() {
    }

    override fun onStop() {
    }

}