package com.myosetpaing.ecommercemvp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDetailDelegate

object ProductModelImpl : BaseModel(), ProductModel {


    override fun getCategoryList(
        accessToken: String,
        page: Int,
        networkFailure: (String) -> Unit
    ): LiveData<List<CategoryVO>> {

        mDataAgent.loadCategory(page, accessToken, object : CategoryDelegate {
            override fun onSuccess(categoryList: List<CategoryVO>) {
                mDataBase.categoryDao().insertCategoryList(categoryList)
            }

            override fun onFail(msg: String) {
                networkFailure(msg)
            }

        })
        return mDataBase.categoryDao().getCategoryList()
    }


    override fun getProductList(accessToken: String, page: Int, networkFailure: (String) -> Unit): LiveData<List<ProductVO>> {
        mDataAgent.loadProduct(page, accessToken, object : ProductDelegate {
            override fun onSuccess(productList: List<ProductVO>) {
                mDataBase.productDao().insertProductList(productList)
            }

            override fun onFail(msg: String) {
               networkFailure(msg)
            }

        })
        return mDataBase.productDao().getProductList()
    }


    override fun getProductDetail(productId: Int, productDetailDelegate: ProductDetailDelegate) {
        val productDetail = mDataBase.productDao().getProductById(productId)
        productDetailDelegate.onSuccess(productDetail)
    }

}