package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.model.*
import com.myosetpaing.ecommercemvp.mvp.presenters.BasePresenter

abstract class BasePresenterImpl : BasePresenter {

    protected lateinit var mProductModel: ProductModel
    protected lateinit var mLoginModel: LoginModel
    protected lateinit var mFavoriteModel: FavoriteModel

    override fun onCreate() {
        mProductModel = ProductModelImpl
        mLoginModel = LoginModelImpl
        mFavoriteModel = FavoriteModelImpl
    }

    override fun onDestory() {
    }

}