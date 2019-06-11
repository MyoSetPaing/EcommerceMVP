package com.myosetpaing.ecommercemvp.mvp.views

import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.delegates.ProductItemDelegate

interface ProductView: BaseView{
    fun showCategory(categoryList: List<CategoryVO>)
    fun showProduct(productList: List<ProductVO>)
    fun showCategoryDetail(categoryId: Int,categoryName: String)
    fun showProductDetail(productId: Int)
    fun showFailMessage(message: String)
    fun goToLoginScreen()
    fun goToFavoriteScreen()

}