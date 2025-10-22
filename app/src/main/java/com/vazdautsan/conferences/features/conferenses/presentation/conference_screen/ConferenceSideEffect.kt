package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

sealed interface ConferenceSideEffect {
    data object NavigateBack : ConferenceSideEffect
    data class OpenRegistration(val url: String) : ConferenceSideEffect
}