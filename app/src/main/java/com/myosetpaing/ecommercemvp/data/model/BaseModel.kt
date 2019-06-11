package com.myosetpaing.ecommercemvp.data.model

import android.content.Context
import com.myosetpaing.ecommercemvp.network.EcommerceDataAgent
import com.myosetpaing.ecommercemvp.network.RetrofitDataAgent
import com.myosetpaing.ecommercemvp.persistence.EcommerceDatabase

abstract class BaseModel{
    val mDataAgent: EcommerceDataAgent = RetrofitDataAgent.getInstance()
    lateinit var mDataBase: EcommerceDatabase

    fun initDatabase(context: Context){
        mDataBase = EcommerceDatabase.getDatabase(context)
    }
}