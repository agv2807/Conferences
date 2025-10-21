package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.utils

import androidx.compose.runtime.Composable
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun CollectSideEffect(
    viewModel: ConferencesViewModel,
    onNavAction: (ConferencesNavAction) -> Unit
) {
    viewModel.collectSideEffect {

    }
}