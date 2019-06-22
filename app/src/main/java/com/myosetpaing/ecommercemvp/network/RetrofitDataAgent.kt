package com.myosetpaing.ecommercemvp.network

import com.google.gson.Gson
import com.myosetpaing.ecommercemvp.delegates.CategoryDelegate
import com.myosetpaing.ecommercemvp.delegates.LoginDelegate
import com.myosetpaing.ecommercemvp.delegates.ProductDelegate
import com.myosetpaing.ecommercemvp.network.responses.GetCategoryResponse
import com.myosetpaing.ecommercemvp.network.responses.GetLoginUserResponse
import com.myosetpaing.ecommercemvp.network.responses.GetProductResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitDataAgent private constructor(): EcommerceDataAgent {



    private val ecommerceApi: EcommerceAPI

    companion object {
        private var INSTANCE: RetrofitDataAgent? = null

        fun getInstance(): RetrofitDataAgent {
            if (INSTANCE == null) {
                INSTANCE = RetrofitDataAgent()
            }
            val i = INSTANCE
            return i!!
        }
    }

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/final-projects/e-commerce/fun/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(okHttpClient)
            .build()
        ecommerceApi = retrofit.create(EcommerceAPI::class.java)
    }

    override fun loadCategory(page: Int, accessToken: String, categoryDelegate: CategoryDelegate) {
        ecommerceApi.loadCategory(accessToken,page).enqueue(object : Callback<GetCategoryResponse>{
            override fun onFailure(call: Call<GetCategoryResponse>, t: Throwable) {
                categoryDelegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetCategoryResponse>, response: Response<GetCategoryResponse>) {

                val categoryListResponse = response.body()
                if(categoryListResponse!!.isResponseSuccess()){
                    categoryDelegate.onSuccess(categoryListResponse.categoryList!!)
                }else{
                    categoryDelegate.onFail("No Category List")
                }
            }

        })
    }

    override fun loadProduct(page: Int, accessToken: String, productDelegate: ProductDelegate) {

        ecommerceApi.loadProduct(accessToken,page).enqueue(object : Callback<GetProductResponse>{

            override fun onFailure(call: Call<GetProductResponse>, t: Throwable) {
                productDelegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetProductResponse>, response: Response<GetProductResponse>) {
                val productListResponse =response.body()
                if(productListResponse!!.isResponseSuccess()){
                    productDelegate.onSuccess(productListResponse.productList!!)
                }else{
                    productDelegate.onFail("No Product List")
                }
            }

        })

    }

    override fun login(phone: String, password: String, loginDelegate: LoginDelegate) {
        ecommerceApi.login(phone,password).enqueue(object : Callback<GetLoginUserResponse>{
            override fun onFailure(call: Call<GetLoginUserResponse>, t: Throwable) {
                loginDelegate.onFail(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetLoginUserResponse>, response: Response<GetLoginUserResponse>) {
                val loginUserResponse = response.body()
                if(loginUserResponse!!.isResponseSuccess()){
                    loginDelegate.onSuccess(loginUserResponse)

                }else{
                    loginDelegate.onFail("Login  fail")
                }
            }
        })
    }
}