package com.myosetpaing.ecommercemvp.mvp.views

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface ProductDetailView : BaseView {
    fun showProductDetail(product: ProductVO)
}