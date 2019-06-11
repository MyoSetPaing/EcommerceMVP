package com.myosetpaing.ecommercemvp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.myosetpaing.ecommercemvp.R

class ProfileActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}
