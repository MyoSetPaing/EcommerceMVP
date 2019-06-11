package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.ProductVO


interface ProductItemDelegate {
    fun onTapProductItem(product: ProductVO)
    fun onTapFavorite(product: ProductVO)
    fun onTapRemoveFavorite(product: ProductVO)
}