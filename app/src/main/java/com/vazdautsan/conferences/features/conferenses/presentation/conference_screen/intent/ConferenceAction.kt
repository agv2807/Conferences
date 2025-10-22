package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent

sealed interface ConferenceAction {
    data object BackClick : ConferenceAction
    data object RegistrationClick : ConferenceAction
}