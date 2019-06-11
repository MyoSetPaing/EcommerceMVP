package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.myosetpaing.ecommercemvp.BottomOffsetDecoration
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.adapters.CategoryRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.adapters.ProductRecyclerViewAdapter
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.ProductPresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.ProductView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ProductView {


    private lateinit var mProductPresenter: ProductPresenterImpl
    private lateinit var mCategoryAdapter: CategoryRecyclerViewAdapter
    private lateinit var mProductAdapter: ProductRecyclerViewAdapter
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
        mProductPresenter = ViewModelProviders.of(this).get(ProductPresenterImpl::class.java)
        mProductPresenter.initPresenter(this)
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
        mProductPresenter.onUIReady(this)

        fab.setOnClickListener {
            mProductPresenter.onTapFavoriteFab()
        }

        ivCategory.setOnClickListener {
            goToProfileActivity()
        }


    }

    private fun init() {
        setBottomOffsetDecoration()
        mCategoryAdapter = CategoryRecyclerViewAdapter(this, mProductPresenter)
        mProductAdapter = ProductRecyclerViewAdapter(this, mProductPresenter)

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

    override fun getMyContext(): Context {
        return this
    }

    private fun goToProfileActivity() {
        val intent = ProfileActivity.newIntent(this)
        startActivity(intent)
    }
}