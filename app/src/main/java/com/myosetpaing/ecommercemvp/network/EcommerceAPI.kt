package com.myosetpaing.ecommercemvp.network

import com.myosetpaing.ecommercemvp.network.responses.GetCategoryResponse
import com.myosetpaing.ecommercemvp.network.responses.GetLoginUserResponse
import com.myosetpaing.ecommercemvp.network.responses.GetProductResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EcommerceAPI{
    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("phone") phone: String, @Field("password") password: String): Call<GetLoginUserResponse>

    @FormUrlEncoded
    @POST("getCategory.php")
    fun loadCategory(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetCategoryResponse>

    @FormUrlEncoded
    @POST("getProducts.php")
    fun loadProduct(@Field("access_token") accessToken: String, @Field("page") page: Int): Call<GetProductResponse>
}