package com.vazdautsan.conferences.features.conferenses.di

import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.ConferenceViewModel
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent.ConferencesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val conferencesModule = module {
    viewModelOf(::ConferencesViewModel)
    viewModel { (conferenceId: Int) ->
        ConferenceViewModel(
            conferenceId = conferenceId,
            getConferenceDetailed = get()
        )
    }
}