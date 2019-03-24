package com.example.matheus.senseifeedbackandroid.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.matheus.senseifeedbackandroid.R

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.rootLayout,
                    LoginFragment.newInstance(), "loginFragment")
                .commit()
        }
    }


}
