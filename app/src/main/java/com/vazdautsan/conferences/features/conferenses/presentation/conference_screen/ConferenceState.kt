package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed

@Immutable
data class ConferenceState(
    val conference: Result<ConferenceDetailed> = Result.Empty()
)