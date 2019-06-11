package com.myosetpaing.ecommercemvp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO


@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryList(categoryList: List<CategoryVO>)

    @Query("select * from category")
    fun getCategoryList(): LiveData<List<CategoryVO>>

    @Query("select count(*) from category")
    fun getCategoryCount(): Int
}