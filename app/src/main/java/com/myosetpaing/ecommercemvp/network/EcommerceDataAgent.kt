package com.myosetpaing.ecommercemvp.network

import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.LoginDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate

interface EcommerceDataAgent {

    companion object {
        val ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916"
    }
    fun loadCategory(page: Int, accessToken: String, categoryDelegate: CategoryDelegate)

    fun loadProduct(page: Int, accessToken: String, productDelegate: ProductDelegate)

    fun login(phone: String, password: String, loginDelegate: LoginDelegate)
}