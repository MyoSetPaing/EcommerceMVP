package com.myosetpaing.ecommercemvp.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO

class CategoryListConverter {
    @TypeConverter
    fun fromListToJson(category: List<CategoryVO>): String {
        return Gson().toJson(category)
    }

    @TypeConverter
    fun fromJsonToList(jsonString: String): List<CategoryVO>{
        val listType = object : TypeToken<List<CategoryVO>>(){}.type
        return Gson().fromJson(jsonString,listType)
    }
}