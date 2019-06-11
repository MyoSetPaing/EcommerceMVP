package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.ProductVO


interface ProductDelegate : BaseNetworkDelegate {
    fun onSuccess(productList: List<ProductVO>)
}