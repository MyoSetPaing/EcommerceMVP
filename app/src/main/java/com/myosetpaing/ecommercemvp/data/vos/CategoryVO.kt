package com.myosetpaing.ecommercemvp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "category")
data class CategoryVO (
    @PrimaryKey
    @ColumnInfo(name = "category_id")
    @SerializedName("category_id")
    var category_id: Int = 0,

    @ColumnInfo(name = "category_name")
    @SerializedName("category_name")
    var category_name: String? = null,

    @ColumnInfo(name = " category_icon")
    @SerializedName("category_icon")
    var category_icon: String? = null,

    @ColumnInfo(name = "category_color ")
    @SerializedName("category_color")
    var category_color: String? = null

)
