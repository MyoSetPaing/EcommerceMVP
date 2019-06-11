package com.myosetpaing.ecommercemvp.data.vos

import com.google.gson.annotations.SerializedName

class SellingVO {

    @SerializedName("product_id")
    private var productId: Int = 0

    @SerializedName("product_name")
    private var productName: String? = null

    @SerializedName("product_price")
    private var productPrice: String? = null

    @SerializedName("image_url")
    private var imageUrl: String? = null
}