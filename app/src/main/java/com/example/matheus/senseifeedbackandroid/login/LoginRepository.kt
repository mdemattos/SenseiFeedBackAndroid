package com.example.matheus.senseifeedbackandroid.login

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface LoginRepository {

    fun login(loginRequest: LoginRequest): LoginResponse

    class Network(private val service: LoginService) : LoginRepository {

        override fun login(loginRequest: LoginRequest): LoginResponse {
            val result =  request(service.login(loginRequest), { it }, LoginResponse(0))
            return result ?: LoginResponse(0)
        }

        private fun <T, R> request(deferred: Deferred<LoginResponse?>, transform: (T) -> R, default: T): LoginResponse? {

            var response = LoginResponse(0)

//            val launch = GlobalScope.launch {
//                response = deferred.await() ?: LoginResponse(0)
//            }

            return response
        }
    }
}