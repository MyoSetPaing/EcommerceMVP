package com.myosetpaing.ecommercemvp.mvp.views

interface LoginView : BaseView{
    fun showMainActivity()
    fun showLoginFailMessage(msg: String)
}