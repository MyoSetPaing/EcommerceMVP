package com.myosetpaing.ecommercemvp.delegates

import com.myosetpaing.ecommercemvp.network.responses.GetLoginUserResponse

interface LoginDelegate : BaseNetworkDelegate{

    fun onSuccess(loginUser: GetLoginUserResponse)
}
