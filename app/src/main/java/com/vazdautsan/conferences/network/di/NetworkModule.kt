package com.vazdautsan.conferences.network.di

import com.vazdautsan.conferences.data.rds.ConferencesRds
import com.vazdautsan.conferences.network.api.ConferencesApi
import com.vazdautsan.conferences.network.rds.ConferencesRdsImpl
import com.vazdautsan.conferences.network.retrofit.retrofitModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

internal val networkModule = module {
    includes(retrofitModule)
    factory { get<Retrofit>(qualifier = named("retrofit")).create(ConferencesApi::class.java) }
    factoryOf(::ConferencesRdsImpl) {
        bind<ConferencesRds>()
    }
}