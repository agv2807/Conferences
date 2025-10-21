package com.vazdautsan.conferences.domain.model.conferences

data class ConferenceLandingItem(
    val categories: List<String>,
    val city: String,
    val country: String,
    val endDate: String,
    val format: ConferenceFormat,
    val id: Int,
    val imageSrc: String?,
    val name: String,
    val startDate: String,
    val status: ConferenceStatus,
    val statusTitle: String,
    val isNewMonth: Boolean
)