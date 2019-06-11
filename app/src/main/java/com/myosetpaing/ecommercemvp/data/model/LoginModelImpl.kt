package com.myosetpaing.ecommercemvp.data.model

import com.myosetpaing.ecommercemvp.data.vos.LoginUserVO
import com.myosetpaing.ecommercemvp.delegates.LoginDelegate
import com.myosetpaing.ecommercemvp.network.responses.GetLoginUserResponse

object LoginModelImpl: BaseModel(),LoginModel{


    override fun loginUser(phone: String, password: String, loginDelegate: LoginDelegate) {

        mDataAgent.login(phone,password,object : LoginDelegate{
            override fun onSuccess(loginUser: GetLoginUserResponse) {
                mDataBase.loginDao().insertLoginUser(loginUser.loginUser)
                loginDelegate.onSuccess(loginUser)

            }

            override fun onFail(msg: String) {
                loginDelegate.onFail(msg)
            }

        })
    }

    override fun isUserLogin(): Boolean {
        return mDataBase.isUserLogin()
    }

    override fun getUserInformation(): LoginUserVO {
        return  mDataBase.loginDao().getUserInformation()
    }

}