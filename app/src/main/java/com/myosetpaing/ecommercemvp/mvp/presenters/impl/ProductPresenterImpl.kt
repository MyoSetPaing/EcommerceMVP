package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import androidx.lifecycle.Observer
import com.myosetpaing.ecommercemvp.activities.BaseActivity
import com.myosetpaing.ecommercemvp.data.model.*
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductPresenter
import com.myosetpaing.ecommercemvp.mvp.views.ProductView
import com.myosetpaing.ecommercemvp.network.EcommerceDataAgent


class ProductPresenterImpl : BasePresenterImpl<ProductView>(), ProductPresenter {


    private val mProductModel: ProductModel = ProductModelImpl
    private val mLoginModel: LoginModel = LoginModelImpl
    private val mFavoriteModel: FavoriteModel = FavoriteModelImpl
    override fun onUIReady(activity: BaseActivity) {

        if (mLoginModel.isUserLogin()) {
            mProductModel.getCategoryList(EcommerceDataAgent.ACCESS_TOKEN, 1) {
                mView.showFailMessage(it)
            }.observe(activity, Observer {
                if (it != null) {
                    mView.showCategory(it)
                } else {
                    mView.showFailMessage("No Category List")
                }
            })

            mProductModel.getProductList(EcommerceDataAgent.ACCESS_TOKEN, 1) {
                mView.showFailMessage(it)
            }.observe(activity, Observer {
                if (it != null) {
                    mView.showProduct(it)
                }
                mView.showFailMessage("No Product List")
            })

        } else {
            mView.goToLoginScreen()
        }

    }

    override fun onTapFavoriteFab() {
        mView.goToFavoriteScreen()
    }


    override fun onTapCategoryItem(category: CategoryVO) {
        mView.showCategoryDetail(category.category_id, category.category_name!!)
    }

    override fun onTapProductItem(product: ProductVO) {
        mView.showProductDetail(product.product_id)
    }

    override fun onTapFavorite(product: ProductVO) {
        mFavoriteModel.addToFavoriteList(product.product_id)
    }

    override fun onTapRemoveFavorite(product: ProductVO) {
        mFavoriteModel.removeFromFavoriteLsit(product.product_id)
    }


}