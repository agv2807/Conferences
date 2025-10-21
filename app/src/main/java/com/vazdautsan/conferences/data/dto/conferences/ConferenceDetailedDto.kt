package com.vazdautsan.conferences.data.dto.conferences

import com.google.gson.annotations.SerializedName
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed

data class ConferenceDetailedDto(
    @SerializedName("about")
    val about: String?,
    @SerializedName("categories")
    val categories: List<ConferenceLandingItemDto.Category?>?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("city_id")
    val cityId: Int?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("country_id")
    val countryId: Int?,
    @SerializedName("custom_date")
    val customDate: String?,
    @SerializedName("end_date")
    val endDate: String?,
    @SerializedName("format")
    val format: ConferenceFormatDto?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: ConferenceLandingItemDto.Image?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("oneday")
    val oneDay: Int?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("register_url")
    val registerUrl: String?,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("status")
    val status: ConferenceStatusDto?,
    @SerializedName("status_title")
    val statusTitle: String?,
    @SerializedName("type")
    val type: ConferenceLandingItemDto.Type?,
    @SerializedName("type_id")
    val typeId: Int?,
    @SerializedName("url")
    val url: String?
) {
    fun toDomain() = run {
        ConferenceDetailed(
            type = type?.name ?: "",
            name = name ?: "",
            imageUrl = image?.url ?: "",
            categories = categories?.mapNotNull { it?.name } ?: emptyList(),
            startDate = startDate ?: "",
            position = city ?: "",
            registerUrl = registerUrl ?: "",
            description = about ?: ""
        )
    }
}