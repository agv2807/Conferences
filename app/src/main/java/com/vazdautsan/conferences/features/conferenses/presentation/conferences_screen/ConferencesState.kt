package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.PagingData

@Immutable
data class ConferencesState(
    val conferences: PagingData<ConferenceLandingItem> = PagingData.empty()
)