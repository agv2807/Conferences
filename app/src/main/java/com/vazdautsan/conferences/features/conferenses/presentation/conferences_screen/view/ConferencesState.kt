package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.paging.PagingData
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.model.ConferenceLandingItemUi

@Immutable
data class ConferencesState(
    val conferences: PagingData<ConferenceLandingItemUi> = PagingData.Companion.empty()
)