package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface ProductDetailDelegate {

    fun onSuccess(product: ProductVO)

}
