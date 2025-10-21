package com.vazdautsan.conferences.domain.di

import com.vazdautsan.conferences.domain.helper.helperModule
import com.vazdautsan.conferences.domain.use_case.GetPagingConferences
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val domainModule = module {
    includes(helperModule)
    factoryOf(::GetPagingConferences)
}