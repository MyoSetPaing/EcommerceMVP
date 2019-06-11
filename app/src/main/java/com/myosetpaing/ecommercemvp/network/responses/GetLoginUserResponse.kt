package com.myosetpaing.ecommercemvp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.ecommercemvp.data.vos.*

data class GetLoginUserResponse(

    @SerializedName("login_user")
    val loginUser: LoginUserVO,

    @SerializedName("favorite_list")
    val favouriteList: List<FavoriteVO>,

    @SerializedName("selling_list")
    val sellingList: List<SellingVO>,

    @SerializedName("sold_list")
    val soldList: List<SoldVO>,

    @SerializedName("bought_list")
    val boughtList: List<BoughtVO>

) : BaseResponse()