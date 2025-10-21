package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen

sealed interface ConferencesAction {
    data class ConferenceClick(val id: Int) : ConferencesAction
}