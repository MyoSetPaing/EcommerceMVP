package com.myosetpaing.ecommercemvp.data.model

import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDetailDelegate

object ProductModelImpl : BaseModel(), ProductModel {


    override fun getCategoryList(accessToken: String, page: Int, categoryDelegate: CategoryDelegate): List<CategoryVO> {

        val categoryList = mDataBase.categoryDao().getCategoryList()
        mDataAgent.loadCategory(page, accessToken, object : CategoryDelegate {
            override fun onSuccess(categoryList: List<CategoryVO>) {
                mDataBase.categoryDao().insertCategoryList(categoryList)
                val categoryListDB = mDataBase.categoryDao().getCategoryList()
                categoryDelegate.onSuccess(categoryListDB)
            }

            override fun onFail(msg: String) {
                if (mDataBase.isCategoryAvailable()) {
                    val categoryListDB = mDataBase.categoryDao().getCategoryList()
                    categoryDelegate.onSuccess(categoryListDB)
                } else {
                    categoryDelegate.onFail(msg)
                }
            }

        })
        return categoryList
    }

    override fun getProductList(accessToken: String, page: Int, productDelegate: ProductDelegate): List<ProductVO> {
        val productList = mDataBase.productDao().getProductList()
        mDataAgent.loadProduct(page, accessToken, object : ProductDelegate {
            override fun onSuccess(productList: List<ProductVO>) {
                mDataBase.productDao().insertProductList(productList)
                val productListDB = mDataBase.productDao().getProductList()
                productDelegate.onSuccess(productListDB)
            }

            override fun onFail(msg: String) {

                if (mDataBase.isCategoryAvailable()) {
                    val productListDB = mDataBase.productDao().getProductList()
                    productDelegate.onSuccess(productListDB)
                } else {
                    productDelegate.onFail(msg)
                }
            }

        })
        return productList
    }

    override fun getProductDetail(productId: Int, productDetailDelegate: ProductDetailDelegate) {
        val productDetail = mDataBase.productDao().getProductById(productId)
        productDetailDelegate.onSuccess(productDetail)
    }

}