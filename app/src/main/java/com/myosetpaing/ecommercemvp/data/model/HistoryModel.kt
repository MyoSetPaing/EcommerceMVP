package com.myosetpaing.ecommercemvp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface HistoryModel {

    fun getHistory(): LiveData<List<ProductVO>>
    fun addHistory(productId: Int)
}