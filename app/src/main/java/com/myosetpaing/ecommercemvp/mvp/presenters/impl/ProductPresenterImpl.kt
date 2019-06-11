package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductPresenter
import com.myosetpaing.ecommercemvp.mvp.views.ProductView
import com.myosetpaing.ecommercemvp.network.EcommerceDataAgent


class ProductPresenterImpl(val mProductView: ProductView) : BasePresenterImpl(), ProductPresenter {


    override fun onUIReady() {

        if (mLoginModel.isUserLogin()) {
            val categoryList =
                mProductModel.getCategoryList(EcommerceDataAgent.ACCESS_TOKEN, 1, object : CategoryDelegate {
                    override fun onSuccess(categoryList: List<CategoryVO>) {
                        mProductView.showCategory(categoryList)
                    }

                    override fun onFail(msg: String) {
                        mProductView.showFailMessage(msg)
                    }

                })
            mProductView.showCategory(categoryList)

            val productList =
                mProductModel.getProductList(EcommerceDataAgent.ACCESS_TOKEN, 1, object : ProductDelegate {
                    override fun onSuccess(productList: List<ProductVO>) {
                        mProductView.showProduct(productList)
                    }

                    override fun onFail(msg: String) {
                        mProductView.showFailMessage(msg)
                    }

                })
            mProductView.showProduct(productList)
        } else {
            mProductView.goToLoginScreen()
        }

    }

    override fun onTapFavoriteFab() {
        mProductView.goToFavoriteScreen()
    }


    override fun onTapCategoryItem(category: CategoryVO) {
        mProductView.showCategoryDetail(category.category_id, category.category_name!!)
    }

    override fun onTapProductItem(product: ProductVO) {
        mProductView.showProductDetail(product.product_id)
    }

    override fun onTapFavorite(product: ProductVO) {
        mFavoriteModel.addToFavoriteList(product.product_id)
    }

    override fun onTapRemoveFavorite(product: ProductVO) {
        mFavoriteModel.removeFromFavoriteLsit(product.product_id)
    }

    override fun onStart() {
    }

    override fun onStop() {
    }
}