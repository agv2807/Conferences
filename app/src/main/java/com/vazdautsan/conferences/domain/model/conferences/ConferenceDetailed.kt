package com.vazdautsan.conferences.domain.model.conferences

data class ConferenceDetailed(
    val type: String,
    val name: String,
    val imageUrl: String?,
    val categories: List<String>,
    val startDate: String,
    val position: String,
    val registerUrl: String,
    val description: String
)