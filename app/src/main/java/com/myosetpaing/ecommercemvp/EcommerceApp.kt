package com.myosetpaing.ecommercemvp

import android.app.Application
import com.myosetpaing.ecommercemvp.data.model.FavoriteModelImpl
import com.myosetpaing.ecommercemvp.data.model.HistoryModelImpl
import com.myosetpaing.ecommercemvp.data.model.LoginModelImpl
import com.myosetpaing.ecommercemvp.data.model.ProductModelImpl

class EcommerceApp : Application() {
    companion object {
        const val TAG = "EcommerceApp"
    }

    override fun onCreate() {
        super.onCreate()
        ProductModelImpl.initDatabase(applicationContext)
        LoginModelImpl.initDatabase(applicationContext)
        FavoriteModelImpl.initDatabase(applicationContext)
        HistoryModelImpl.initDatabase(applicationContext)
    }
}