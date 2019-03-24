package com.example.matheus.senseifeedbackandroid.di

import com.example.matheus.senseifeedbackandroid.BuildConfig
import com.example.matheus.senseifeedbackandroid.login.*
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://sensei.livbox.com.br")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        okHttpClientBuilder.build() as OkHttpClient
    }

    single {
        LoginService(get())
    }
}

var loginModule = module {
    single { LoginPresenter(LoginRepository.Network(get()) as LoginRepository)}
}