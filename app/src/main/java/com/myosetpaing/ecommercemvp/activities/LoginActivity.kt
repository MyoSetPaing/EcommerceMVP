package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.myosetpaing.ecommercemvp.R
import com.myosetpaing.ecommercemvp.mvp.presenters.LoginPresenter
import com.myosetpaing.ecommercemvp.mvp.presenters.impl.LoginPresenterImpl
import com.myosetpaing.ecommercemvp.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {


    private var mLoginPresenter: LoginPresenter = LoginPresenterImpl(this)

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            mLoginPresenter.tapUserLoginButton("09783499931", "Abcdefg")
        }

    }


    override fun showMainActivity() {
        startActivity(MainActivity.newIntent(this))
        finish()
    }

    override fun showLoginFailMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
    override fun getMyContext(): Context {
        return this
    }
}

