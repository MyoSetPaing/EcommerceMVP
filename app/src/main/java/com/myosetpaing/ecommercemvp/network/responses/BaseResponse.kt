package com.myosetpaing.ecommercemvp.network.responses

import com.google.gson.annotations.SerializedName

abstract class BaseResponse {
    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null

    @SerializedName("apiVersion")
    var apiVersion: String? = null

    @SerializedName("page")
    var page: Int = 0

    fun isResponseSuccess():Boolean{
        return this.code ==200
    }
}