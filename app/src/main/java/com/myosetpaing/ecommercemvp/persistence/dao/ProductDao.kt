package com.myosetpaing.ecommercemvp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.ecommercemvp.data.vos.ProductVO

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductList(productList: List<ProductVO>)

    @Query("select * from product")
    fun getProductList(): LiveData<List<ProductVO>>

    @Query("select * from product where product_id=:productId")
    fun getProductById(productId: Int): ProductVO

    @Query("select count(*) from product")
    fun getProductCount(): Int

    @Query("select * from product where isFavorite ==1 ")
    fun getFavoriteProductList(): List<ProductVO>

    @Query("update product set isFavorite=:status where product_id= :productId")
    fun doFavoriteOrUnFavorite(productId: Int, status: Int)


}