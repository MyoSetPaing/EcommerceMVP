package com.myosetpaing.ecommercemvp.data.vos

import androidx.room.*
import com.google.gson.annotations.SerializedName


@Entity(tableName = "product", indices = [Index(value = ["product_id"], unique = true)])
data class ProductVO(

    @PrimaryKey
    @ColumnInfo(name = "product_id")
    @SerializedName("product_id")
    var product_id: Int = 0,

    @ColumnInfo(name = "product_name")
    @SerializedName("product_name")
    var product_name: String? = null,

    @ColumnInfo(name = "product_image_url")
    @SerializedName("product_image_url")
    var product_image_url: List<ProductImageUrlVO>? = null,

    @ColumnInfo(name = "product_desc")
    @SerializedName("product_desc")
    var product_desc: String? = null,

    @ColumnInfo(name = "product_price")
    @SerializedName("product_price")
    var product_price: String? = null,

    @ColumnInfo(name = "category")
    @SerializedName("category")
    var category: List<CategoryVO>? = null,

    @ColumnInfo(name = "uploaded_time")
    @SerializedName("uploaded_time")
    var uploaded_time: String? = null,

    @ColumnInfo(name = "uploaded_date")
    @SerializedName("uploaded_date")
    var uploaded_date: String? = null,

    @Embedded(prefix = "seller")
    @SerializedName("seller")
    var seller: SellerVO? = null,

    @ColumnInfo(name = "availability")
    @SerializedName("availability")
    var availability: Boolean? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Int

)