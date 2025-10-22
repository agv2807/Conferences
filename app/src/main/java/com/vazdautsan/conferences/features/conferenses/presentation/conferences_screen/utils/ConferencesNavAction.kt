package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.utils

sealed interface ConferencesNavAction {
    data class Conference(val id: Int) : ConferencesNavAction
}