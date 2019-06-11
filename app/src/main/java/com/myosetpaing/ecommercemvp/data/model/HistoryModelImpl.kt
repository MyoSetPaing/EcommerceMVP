package com.myosetpaing.ecommercemvp.data.model

import androidx.lifecycle.LiveData
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.persistence.entities.HistoryTable

object HistoryModelImpl : BaseModel(), HistoryModel {

    override fun getHistory(): LiveData<List<ProductVO>> {
        return mDataBase.historyDao().getHistory()
    }


    override fun addHistory(productId: Int) {
        mDataBase.historyDao().addHistory(HistoryTable(productId = productId))
    }
}