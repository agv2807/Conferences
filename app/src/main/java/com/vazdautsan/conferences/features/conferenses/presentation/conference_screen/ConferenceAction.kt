package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

sealed interface ConferenceAction {
    data object BackClick : ConferenceAction
}