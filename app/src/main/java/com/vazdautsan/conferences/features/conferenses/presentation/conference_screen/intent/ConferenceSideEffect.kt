package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent

sealed interface ConferenceSideEffect {
    data object NavigateBack : ConferenceSideEffect
    data class OpenRegistration(val url: String) : ConferenceSideEffect
}