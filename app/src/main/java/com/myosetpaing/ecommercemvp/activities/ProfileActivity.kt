package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.adapters.HistoryRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.HistoryPresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.HistoryView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(), HistoryView {


    private lateinit var mHistoryPresenter: HistoryPresenterImpl

    private lateinit var mHistoryAdapter: HistoryRecyclerViewAdapter


    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        mHistoryPresenter = ViewModelProviders.of(this).get(HistoryPresenterImpl::class.java)
        mHistoryPresenter.initPresenter(this)
        mHistoryAdapter = HistoryRecyclerViewAdapter(this)

        rvHistory.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            androidx.recyclerview.widget.RecyclerView.VERTICAL,
            false
        )
        rvHistory.adapter = mHistoryAdapter
        mHistoryPresenter.onUIReady(this)
    }

    override fun showHistoryList(historyList: List<ProductVO>) {
        val size = historyList.size
        radHistory.text = "$size History"
        mHistoryAdapter.setNewData(historyList as MutableList<ProductVO>)
    }

    override fun getMyContext(): Context {
        return this
    }
}
