package com.example.matheus.senseifeedbackandroid

import android.app.Application
import com.example.matheus.senseifeedbackandroid.di.applicationModule
import com.example.matheus.senseifeedbackandroid.di.loginModule
import org.koin.android.ext.android.startKoin

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectMembers()
    }

    private fun injectMembers() = startKoin(this, listOf(applicationModule, loginModule))

}