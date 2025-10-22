package com.vazdautsan.conferences.domain.model.conferences

data class ConferenceLandingItem(
    val categories: List<String>,
    val city: String,
    val country: String,
    val endDate: ConferenceDate,
    val format: ConferenceFormat,
    val id: Int,
    val imageSrc: String?,
    val name: String,
    val startDate: ConferenceDate,
    val status: ConferenceStatus,
    val statusTitle: String,
    val isNewMonth: Boolean,
    val isOneDay: Boolean
)

data class ConferenceDate(
    val day: String,
    val monthShort: String,
    val monthYear: String,
    val date: String
) {
    companion object {
        fun empty() = ConferenceDate(
            day = "",
            monthYear = "",
            monthShort = "",
            date = ""
        )
    }
}