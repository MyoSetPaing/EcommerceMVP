package com.myosetpaing.ecommercemvp.data.model

import com.myosetpaing.ecommercemvp.data.vos.LoginUserVO
import com.myosetpaing.ecommercemvp.delegates.LoginDelegate

interface LoginModel {

    fun loginUser(phone: String,password: String,loginDelegate: LoginDelegate)
    fun isUserLogin(): Boolean
    fun getUserInformation(): LoginUserVO

}