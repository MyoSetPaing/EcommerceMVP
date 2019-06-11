package com.myosetpaing.ecommercemvp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.ecommercemvp.data.vos.FavoriteVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoriteList(favourite: List<FavoriteVO>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavoriteProduct(favorite: FavoriteVO): Long

    @Query("select b.* from favorite as a inner join product as b on a.product_id=b.product_id")
    fun getFavoriteProducts(): List<ProductVO>

    @Query("select * from favorite where product_id=:productId")
    fun getFavoriteCount(productId: Int): Int

    @Query("Delete from favorite where product_id= :productId")
    fun unFavoriteProducts(productId: Int)
}