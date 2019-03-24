package com.example.matheus.senseifeedbackandroid.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.platform.commons.util.StringUtils

internal class ValidationTest {

    @Test
    fun `checks if password length is valid`() {
        val password = "password"
        Assertions.assertTrue(password.length > 4 )
    }

    @Test
    fun `checks if email is valid`() {
        val email = "teste"
        Assertions.assertTrue(email.length >= 4 && !StringUtils.containsWhitespace(email))
    }
}