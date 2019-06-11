package com.myosetpaing.ecommercemvp.persistence.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.myosetpaing.ecommercemvp.data.vos.CategoryVO
import com.myosetpaing.ecommercemvp.data.vos.ProductVO

@Entity(
    tableName = "category_product",
    indices = [Index("product_id"), Index("category_id")],
    primaryKeys = ["product_id", "category_id"],
    foreignKeys = [
        ForeignKey(
            entity = ProductVO::class,
            parentColumns = ["product_id"], childColumns = ["product_id"]
        ),
        ForeignKey(
            entity = CategoryVO::class,
            parentColumns = ["category_id"], childColumns = ["category_id"]
        )]
)
data class ProductTable(

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo(name = "category_id")
    val categoryId: Int

)