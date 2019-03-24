package com.example.matheus.senseifeedbackandroid.login

import com.example.matheus.senseifeedbackandroid.util.Validation

class LoginPresenter(private val loginRepository: LoginRepository) : LoginContract.LoginPresenter {


    override fun performLogin(username: String, password: String) : LoginResponse {
        val validator = Validation()

        return if (!validator.isUsernameValid(username)) {
            LoginResponse(-1)
        } else if (!validator.isPasswordValid(password)) {
            LoginResponse(0)
        } else {
            val request = LoginRequest(username, password)
            loginRepository.login(request)
        }
    }
}