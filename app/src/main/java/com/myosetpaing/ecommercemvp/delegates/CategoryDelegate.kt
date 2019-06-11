package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.data.vos.CategoryVO


interface CategoryDelegate : BaseNetworkDelegate{
    fun onSuccess(categoryList: List<CategoryVO>)
}
