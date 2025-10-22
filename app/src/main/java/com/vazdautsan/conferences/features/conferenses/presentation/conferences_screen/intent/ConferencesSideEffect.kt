package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent

sealed interface ConferencesSideEffect {
    data class OpenConference(val id: Int) : ConferencesSideEffect
}