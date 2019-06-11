package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.adapters.FavoriteRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.FavoritePresenter
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.FavoritePresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.FavoriteView
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : BaseActivity(), FavoriteView {


    private lateinit var mFavoritePresenter: FavoritePresenterImpl
    private lateinit var mAdapter: FavoriteRecyclerViewAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, FavoriteActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        mFavoritePresenter = ViewModelProviders.of(this).get(FavoritePresenterImpl::class.java)
        mFavoritePresenter.initPresenter(this)
        mAdapter = FavoriteRecyclerViewAdapter(mFavoritePresenter)
        rvFavorite.layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
            2,
            androidx.recyclerview.widget.RecyclerView.VERTICAL
        )
        rvFavorite.adapter = mAdapter

        mFavoritePresenter.onUIReady()
    }

    override fun showFavoriteList(favoriteList: List<ProductVO>) {
        mAdapter.setNewData(favoriteList as MutableList<ProductVO>)

    }

    override fun showNoFavoriteList(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showProductDetail(productId: Int) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra(MainActivity.PRODUCT_ID, productId)
        startActivity(intent)
    }

    override fun getMyContext(): Context {
        return this

    }

}
