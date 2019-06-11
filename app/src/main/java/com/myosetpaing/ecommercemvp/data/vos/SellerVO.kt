package com.myosetpaing.ecommercemvp.data.vos

import com.google.gson.annotations.SerializedName

class SellerVO {
    @SerializedName("seller_id")
    var seller_id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("address")
    var address: String? = null

    @SerializedName("phone_no")
    var phone_no: String? = null

    @SerializedName("profile_image")
    var profile_image: String? = null


}



