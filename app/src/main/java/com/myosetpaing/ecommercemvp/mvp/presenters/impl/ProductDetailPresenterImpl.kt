package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.model.ProductModel
import com.myosetpaing.ecommercemvp.data.model.ProductModelImpl
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductDetailDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductDetailPresenter
import com.myosetpaing.ecommercemvp.mvp.views.ProductDetailView

class ProductDetailPresenterImpl : BasePresenterImpl<ProductDetailView>(),
    ProductDetailPresenter {

    private val mProductModel: ProductModel = ProductModelImpl

    override fun onUIReady(productId: Int) {

        mProductModel.getProductDetail(productId, object : ProductDetailDelegate {
            override fun onSuccess(product: ProductVO) {
                mView.showProductDetail(product)
            }

        })

    }


}