package com.vazdautsan.conferences.domain.model.conferences

data class ConferenceDetailed(
    val type: String,
    val name: String,
    val imageUrl: String?,
    val categories: List<String>,
    val startDate: String,
    val city: String,
    val country: String,
    val registerUrl: String,
    val description: String,
    val endDate: String,
    val format: ConferenceFormat,
    val position: String
)