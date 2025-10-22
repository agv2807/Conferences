package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.model.ConferenceDetailedUi

@Immutable
data class ConferenceState(
    val conference: Result<ConferenceDetailedUi> = Result.Empty()
)