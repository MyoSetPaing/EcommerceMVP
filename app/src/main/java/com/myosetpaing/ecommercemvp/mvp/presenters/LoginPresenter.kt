package com.myosetpaing.ecommercemvp.mvp.presenters

interface LoginPresenter : BasePresenter {
    fun tapUserLoginButton(phone: String, password: String)
}