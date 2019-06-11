package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.mvp.presenters.ProductDetailPresenter
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.ProductDetailPresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.ProductDetailView
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.item_view_product.*

class ProductDetailActivity : BaseActivity(), ProductDetailView {

    val mProductDetailPresenter: ProductDetailPresenter = ProductDetailPresenterImpl(this)
    var productId = 0

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        mProductDetailPresenter.onCreate()
        retrieveExtra()
        mProductDetailPresenter.onUIReady(productId)

    }

    fun retrieveExtra() {
        val intent = intent
        productId = intent.getIntExtra(MainActivity.PRODUCT_ID, 0)
    }

    override fun showProductDetail(product: ProductVO) {
        Glide.with(this)
            .load(product.product_image_url!![0].image_url)
            .into(iv_productImage)
        tv_desc.text = product.product_desc
        tv_shop_name.text = product.seller!!.name
        tvProductDetailName.text = product.product_name
        tv_price.text = product.product_price

    }

}
