package com.vazdautsan.conferences.data.di

import com.vazdautsan.conferences.data.repository.ConferencesRepositoryImpl
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val dataModule = module {
    factoryOf(::ConferencesRepositoryImpl) {
        bind<ConferencesRepository>()
    }
}