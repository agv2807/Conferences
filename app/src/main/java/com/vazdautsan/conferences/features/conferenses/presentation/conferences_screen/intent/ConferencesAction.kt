package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent

sealed interface ConferencesAction {
    data class ConferenceClick(val id: Int) : ConferencesAction
}