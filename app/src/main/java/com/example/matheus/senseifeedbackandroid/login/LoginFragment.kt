package com.example.matheus.senseifeedbackandroid.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.matheus.senseifeedbackandroid.R
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

/**
 * A login screen that offers login via email/password.
 *
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), LoginContract.LoginView {

    private val loginPresenter: LoginPresenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInButton.setOnClickListener {
            val response = loginPresenter.performLogin(email.text.toString(), password.text.toString())

            when (response.userId) {
                -1 -> showEmailError()
                0 -> showPasswordError()
                else -> proceed()
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun showEmailError() {
        Toast.makeText(context, "Email error", Toast.LENGTH_LONG).show()
    }

    override fun showPasswordError() {
        Toast.makeText(context, "Password error", Toast.LENGTH_LONG).show()
    }

    fun proceed() {
        Toast.makeText(context, "OK", Toast.LENGTH_LONG).show()
    }

}
