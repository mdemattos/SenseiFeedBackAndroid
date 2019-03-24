package com.example.matheus.senseifeedbackandroid.login

interface LoginContract {

    interface LoginView {
        fun showEmailError()
        fun showPasswordError()
    }

    interface LoginPresenter {
        fun performLogin(email: String, password: String) : LoginResponse
    }

}