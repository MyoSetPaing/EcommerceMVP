package com.myosetpaing.ecommercemvp.data.vos

import com.google.gson.annotations.SerializedName

class BoughtVO {

    @SerializedName("product_id")
    var productId: Int = 0

    @SerializedName("product_name")
    var productName: String? = null

    @SerializedName("product_price")
    var productPrice: String? = null

    @SerializedName("product_image_url")
    var productImageUrl: String? = null
}