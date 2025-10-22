package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent.ConferenceSideEffect
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent.ConferenceViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CollectSideEffect(
    viewModel: ConferenceViewModel,
    onNavAction: (ConferenceNavAction) -> Unit
) {
    val uriHandler = LocalUriHandler.current
    viewModel.collectSideEffect {
        when (it) {
            is ConferenceSideEffect.NavigateBack -> {
                onNavAction(ConferenceNavAction.Back)
            }

            is ConferenceSideEffect.OpenRegistration -> {
                uriHandler.openUri(it.url)
            }
        }
    }
}