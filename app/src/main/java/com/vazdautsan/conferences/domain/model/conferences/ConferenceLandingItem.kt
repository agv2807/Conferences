package com.vazdautsan.conferences.domain.model.conferences

data class ConferenceLandingItem(
    val categories: List<String>,
    val city: String,
    val country: String,
    val endDate: String,
    val format: String,
    val id: Int,
    val imageSrc: String?,
    val name: String,
    val startDate: String,
    val status: String,
    val statusTitle: String,
    val type: String,
    val isNewMonth: Boolean
)