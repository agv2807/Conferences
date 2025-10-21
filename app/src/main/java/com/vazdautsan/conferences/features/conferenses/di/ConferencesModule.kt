package com.vazdautsan.conferences.features.conferenses.di

import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val conferencesModule = module {
    viewModelOf(::ConferencesViewModel)
}