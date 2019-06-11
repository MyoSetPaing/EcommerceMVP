package com.myosetpaing.ecommercemvp.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import com.myosetpaing.ecommercemvp.persistence.entities.HistoryTable

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHistory(history: HistoryTable)

    @Query("select b.* from history as a inner join product as b on a.product_id=b.product_id order by updated_at desc")
    fun getHistory():LiveData<List<ProductVO>>
}