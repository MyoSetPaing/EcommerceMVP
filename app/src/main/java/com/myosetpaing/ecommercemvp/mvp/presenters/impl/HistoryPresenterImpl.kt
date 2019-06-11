package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import androidx.lifecycle.Observer
import com.myosetpaing.ecommercemvp.activities.BaseActivity
import com.myosetpaing.ecommercemvp.data.model.HistoryModel
import com.myosetpaing.ecommercemvp.data.model.HistoryModelImpl
import com.myosetpaing.ecommercemvp.mvp.presenters.HistoryPresenter
import com.myosetpaing.ecommercemvp.mvp.views.HistoryView

class HistoryPresenterImpl: BasePresenterImpl<HistoryView>(),HistoryPresenter{

    private val mHistoryModel: HistoryModel = HistoryModelImpl

    override fun onUIReady(activity: BaseActivity) {
        mHistoryModel.getHistory().observe(activity, Observer {
            mView.showHistoryList(it)

        })
    }

}