package com.myosetpaing.ecommercemvp.data.vos

import com.google.gson.annotations.SerializedName

class ProductImageUrlVO {
    @SerializedName("id")
    var productImageUrlId: Int = 0
    @SerializedName("image_url")
    var image_url: String? = null

}

