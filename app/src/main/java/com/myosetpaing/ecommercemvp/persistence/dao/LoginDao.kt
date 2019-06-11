package com.myosetpaing.ecommercemvp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.ecommercemvp.data.vos.LoginUserVO

@Dao
interface LoginDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoginUser(loginUser: LoginUserVO): Long

    @Query("select count(*) from login_user")
    fun getUserCount(): Int

    @Query("select * from login_user")
    fun getUserInformation(): LoginUserVO

}