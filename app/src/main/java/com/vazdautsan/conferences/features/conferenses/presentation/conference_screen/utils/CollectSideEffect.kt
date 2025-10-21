package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils

import androidx.compose.runtime.Composable
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.ConferenceSideEffect
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.ConferenceViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CollectSideEffect(
    viewModel: ConferenceViewModel,
    onNavAction: (ConferenceNavAction) -> Unit
) {
    viewModel.collectSideEffect {
        when (it) {
            is ConferenceSideEffect.NavigateBack -> {
                onNavAction(ConferenceNavAction.Back)
            }
        }
    }
}