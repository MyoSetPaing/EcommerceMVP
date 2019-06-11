package com.myosetpaing.ecommercemvp.mvp.views

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface ProductDetailView {
    fun showProductDetail(product: ProductVO)
}