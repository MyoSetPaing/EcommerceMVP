package com.myosetpaing.ecommercemvp.network.responses

import com.google.gson.annotations.SerializedName
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO

class GetCategoryResponse : BaseResponse(){
    @SerializedName("categoryList")
    var categoryList: List<CategoryVO> ? = null
}




