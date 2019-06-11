package com.myosetpaing.ecommercemvp.data.model

import com.myosetpaing.ecommercemvp.delegates.FavoriteDelegate

object FavoriteModelImpl: BaseModel(),FavoriteModel{


    override fun getFavoriteModel(favoriteDelegate: FavoriteDelegate) {
        val favoriteList = mDataBase.productDao().getFavoriteProductList()

        if(favoriteList.isEmpty()){
            favoriteDelegate.emptyFavoriteList("No Favorite List")
        }else{
            favoriteDelegate.onSuccess(favoriteList)
        }
    }

    override fun addToFavoriteList(productId: Int) {
        mDataBase.productDao().doFavoriteOrUnFavorite(productId,1)
    }

    override fun removeFromFavoriteLsit(productId: Int) {
        mDataBase.productDao().doFavoriteOrUnFavorite(productId,0)
    }

}