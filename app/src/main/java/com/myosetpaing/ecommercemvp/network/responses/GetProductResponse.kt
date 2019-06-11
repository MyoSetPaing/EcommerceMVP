package com.myosetpaing.ecommercemvp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.ecommercemvp.data.vos.ProductVO


class GetProductResponse : BaseResponse() {

    @SerializedName("products")
    var productList: List<ProductVO>? = null
}




