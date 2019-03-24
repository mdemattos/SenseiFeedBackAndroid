package com.example.matheus.senseifeedbackandroid.login

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

internal interface LoginApi {

    @POST("/api/Auth") fun login(@Body loginRequest: LoginRequest) : Deferred<LoginResponse>

}