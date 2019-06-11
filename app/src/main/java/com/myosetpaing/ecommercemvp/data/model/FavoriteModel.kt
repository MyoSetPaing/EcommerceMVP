package com.myosetpaing.ecommercemvp.data.model

import com.myosetpaing.ecommercemvp.delegates.FavoriteDelegate


interface FavoriteModel {
    fun getFavoriteModel(favoriteDelegate: FavoriteDelegate)
    fun addToFavoriteList(productId: Int)
    fun removeFromFavoriteLsit(productId: Int)
}