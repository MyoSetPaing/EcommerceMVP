package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myosetpaing.ecommercemvp.BottomOffsetDecoration
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.adapters.CategoryRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.adapters.ProductRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductPresenter
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.ProductPresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.ProductView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ProductView {


    private val mProductPresenter: ProductPresenter = ProductPresenterImpl(this)
    private val mCategoryAdapter: CategoryRecyclerViewAdapter = CategoryRecyclerViewAdapter(this, mProductPresenter)
    private val mProductAdapter: ProductRecyclerViewAdapter = ProductRecyclerViewAdapter(this, mProductPresenter)
    private lateinit var bottomOffsetDecoration: BottomOffsetDecoration

    companion object {
        const val PRODUCT_ID = "product_id"
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        rv_category.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
            false
        )
        rv_category.adapter = mCategoryAdapter
        rv_productList.layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            this,
            2,
            androidx.recyclerview.widget.RecyclerView.VERTICAL,
            false
        )
        rv_productList.adapter = mProductAdapter
        rv_productList.addItemDecoration(bottomOffsetDecoration)
        mProductPresenter.onUIReady()

        fab.setOnClickListener {
            mProductPresenter.onTapFavoriteFab()
        }

    }

    private fun init() {
        mProductPresenter.onCreate()
        setBottomOffsetDecoration()

    }


    override fun showCategory(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setNewData(categoryList as MutableList<CategoryVO>)
    }

    override fun showProduct(productList: List<ProductVO>) {
        mProductAdapter.setNewData(productList as MutableList<ProductVO>)

    }

    override fun goToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    override fun showFailMessage(message: String) {


    }


    override fun showCategoryDetail(categoryId: Int, categoryName: String) {
    }

    override fun showProductDetail(productId: Int) {
        val intent = ProductDetailActivity.newIntent(this)
        intent.putExtra(PRODUCT_ID, productId)
        startActivity(intent)
    }

    override fun goToFavoriteScreen() {
        val intent = FavoriteActivity.newIntent(this)
        startActivity(intent)
    }

    private fun setBottomOffsetDecoration() {
        bottomOffsetDecoration = BottomOffsetDecoration(resources.getDimension(R.dimen.bottom_offset_dp).toInt())
    }

}