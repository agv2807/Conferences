package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.model

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed

@Immutable
data class ConferenceDetailedUi(
    val type: String,
    val name: String,
    val imageUrl: String?,
    val categories: List<String>,
    val startDate: String,
    val registerUrl: String,
    val description: String,
    val position: String
)

fun ConferenceDetailed.toUi() = run {
    ConferenceDetailedUi(
        type = type,
        name = name,
        imageUrl = imageUrl,
        categories = categories,
        startDate = startDate,
        registerUrl = registerUrl,
        description = description,
        position = position
    )
}