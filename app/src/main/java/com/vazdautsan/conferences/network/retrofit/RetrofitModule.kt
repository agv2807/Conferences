package com.vazdautsan.conferences.network.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal val retrofitModule = module {
    single(qualifier = named("http_client")) {
        OkHttpClient.Builder().build()
    }

    single(qualifier = named("retrofit")) {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(get(named("http_client")))
            .baseUrl("https://partnerkin.com/")
            .build()
    }
}