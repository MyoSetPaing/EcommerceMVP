package com.myosetpaing.ecommercemvp.persistence.entities

import androidx.room.*
import com.myosetpaing.ecommercemvp.data.vos.ProductVO
import java.util.*

@Entity(
    tableName = "history",
    indices = [Index("product_id")],
    foreignKeys = [ForeignKey(
        entity = ProductVO::class
        , parentColumns = ["product_id"], childColumns = ["product_id"]
    )]
)
data class HistoryTable(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "history_id")
    val historyId: Int? = null,

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "updated_at")
    val date: Date = Date()
)