package com.myosetpaing.ecommercemvp.mvp.views

import com.myosetpaing.ecommercemvp.data.vos.ProductVO

interface HistoryView: BaseView{

    fun showHistoryList(historyList: List<ProductVO>)

}