package com.myosetpaing.ecommercemvp.mvp.presenters.impl

import com.myosetpaing.ecommercemvp.data.model.LoginModel
import com.myosetpaing.ecommercemvp.data.model.LoginModelImpl
import com.myosetpaing.ecommercemvp.delegates.LoginDelegate
import com.myosetpaing.ecommercemvp.mvp.presenters.LoginPresenter
import com.myosetpaing.ecommercemvp.mvp.views.LoginView
import com.myosetpaing.ecommercemvp.network.responses.GetLoginUserResponse

class LoginPresenterImpl(val mLoginView: LoginView) : BasePresenterImpl<LoginView>(), LoginPresenter {

    private val mLoginModel: LoginModel = LoginModelImpl

    override fun tapUserLoginButton(phone: String, password: String) {

        mLoginModel.loginUser(phone, password, object : LoginDelegate {
            override fun onSuccess(loginUser: GetLoginUserResponse) {
                mLoginView.showMainActivity()
            }

            override fun onFail(msg: String) {
                mLoginView.showLoginFailMessage(msg)
            }

        })
    }

}