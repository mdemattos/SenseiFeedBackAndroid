package com.example.matheus.senseifeedbackandroid.login

import retrofit2.Retrofit

class LoginService(retrofit: Retrofit) : LoginApi {

    private val loginApi by lazy { retrofit.create(LoginApi::class.java) }
    override fun login(loginRequest: LoginRequest) = loginApi.login(loginRequest)

}