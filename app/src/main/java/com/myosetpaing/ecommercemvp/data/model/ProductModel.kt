package com.myosetpaing.ecommercemvp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDetailDelegate

interface ProductModel{
    fun getCategoryList(accessToken: String, page: Int,networkFailure: (String) -> Unit): LiveData<List<CategoryVO>>
    fun getProductList(accessToken: String,page: Int,networkFailure: (String) -> Unit): LiveData<List<ProductVO>>
    fun getProductDetail(productId: Int,productDetailDelegate: ProductDetailDelegate)
}