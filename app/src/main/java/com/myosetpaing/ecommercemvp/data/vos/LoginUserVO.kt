package com.myosetpaing.ecommercemvp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login_user")
class LoginUserVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    @SerializedName("user_id")
    var userId: Int = 0

    @ColumnInfo(name="name")
    @SerializedName("name")
    var name: String? = null

    @ColumnInfo(name="address")
    @SerializedName("address")
    var address: String? = null

    @ColumnInfo(name="phone_no")
    @SerializedName("phone_no")
    var phoneNo: String? = null

    @ColumnInfo(name="wallet")
    @SerializedName("wallet")
    var wallet: String? = null

    @ColumnInfo(name="profile_image")
    @SerializedName("profile_image")
    var profileImage: String? = null

    @ColumnInfo(name="cover_image")
    @SerializedName("cover_image")
    var coverImage: String? = null

}