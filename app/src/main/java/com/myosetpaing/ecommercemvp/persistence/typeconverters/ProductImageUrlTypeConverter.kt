package com.myosetpaing.ecommercemvp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.ecommercemvp.data.vos.ProductImageUrlVO

class ProductImageUrlTypeConverter{
    @TypeConverter
    fun fromListToJson(imgList: List<ProductImageUrlVO>): String {
        return Gson().toJson(imgList)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<ProductImageUrlVO> {

        val listType = object : TypeToken<List<ProductImageUrlVO>>() {}.type

        return Gson().fromJson(jsonString, listType)
    }

}