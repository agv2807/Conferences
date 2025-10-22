package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils

sealed interface ConferenceNavAction {
    data object Back : ConferenceNavAction
}