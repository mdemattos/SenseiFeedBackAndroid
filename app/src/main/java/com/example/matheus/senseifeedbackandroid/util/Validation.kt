package com.example.matheus.senseifeedbackandroid.util


class Validation {

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }

    fun isUsernameValid(email: String): Boolean {
        return email.length >= 4 && !email.contains(" ")
    }

}