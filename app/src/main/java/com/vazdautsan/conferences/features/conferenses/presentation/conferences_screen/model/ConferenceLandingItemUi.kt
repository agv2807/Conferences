package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.model

import androidx.compose.runtime.Immutable
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDate
import com.vazdautsan.conferences.domain.model.conferences.ConferenceFormat
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.model.conferences.ConferenceStatus

@Immutable
data class ConferenceLandingItemUi(
    val categories: List<String>,
    val endDate: ConferenceDateUi,
    val format: ConferenceFormat,
    val id: Int,
    val imageSrc: String?,
    val name: String,
    val startDate: ConferenceDateUi,
    val status: ConferenceStatus,
    val statusTitle: String,
    val isNewMonth: Boolean,
    val isOneDay: Boolean,
    val position: String,
    val monthYear: String
)

fun ConferenceLandingItem.toUi() = run {
    ConferenceLandingItemUi(
        categories = categories,
        endDate = endDate.toUi(),
        format = format,
        id = id,
        imageSrc = imageSrc,
        name = name,
        startDate = startDate.toUi(),
        status = status,
        statusTitle = statusTitle,
        isNewMonth = isNewMonth,
        isOneDay = isOneDay,
        position = position,
        monthYear = if (isNewMonth) startDate.monthYear else ""
    )
}

@Immutable
data class ConferenceDateUi(
    val day: String,
    val monthShort: String
)

fun ConferenceDate.toUi() = run {
    ConferenceDateUi(
        day = day,
        monthShort = monthShort
    )
}