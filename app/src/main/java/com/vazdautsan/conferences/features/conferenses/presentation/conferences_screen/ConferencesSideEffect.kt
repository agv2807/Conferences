package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen

sealed interface ConferencesSideEffect {
    data class OpenConference(val id: Int) : ConferencesSideEffect
}