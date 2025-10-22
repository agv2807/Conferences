package com.vazdautsan.conferences.local_storage

import com.vazdautsan.conferences.data.lds.ApiKeyLds
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val localStorageModule = module {
    singleOf(::ApiKeyLdsImpl) {
        bind<ApiKeyLds>()
    }
}