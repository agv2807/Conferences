package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.model.ConferenceLandingItemUi

@Immutable
data class ConferencesState(
    val conferences: Result<List<ConferenceLandingItemUi>> = Result.Empty()
)