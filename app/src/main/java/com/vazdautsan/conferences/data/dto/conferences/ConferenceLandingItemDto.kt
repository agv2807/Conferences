package com.vazdautsan.conferences.data.dto.conferences

import com.google.gson.annotations.SerializedName
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDate
import com.vazdautsan.conferences.domain.model.conferences.ConferenceFormat
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.model.conferences.ConferenceStatus
import java.text.SimpleDateFormat
import java.util.Locale

data class ConferenceLandingItemDto(
    @SerializedName("view_type")
    val viewType: Int?,
    @SerializedName("conference")
    val conference: Conference
) {
    data class Conference(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("format")
        val format: ConferenceFormatDto?,
        @SerializedName("status")
        val status: ConferenceStatusDto?,
        @SerializedName("status_title")
        val statusTitle: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("image")
        val image: Image?,
        @SerializedName("rating")
        val rating: String?,
        @SerializedName("start_date")
        val startDate: String?,
        @SerializedName("end_date")
        val endDate: String?,
        @SerializedName("oneday")
        val oneday: Int?,
        @SerializedName("custom_date")
        val customDate: String?,
        @SerializedName("country_id")
        val countryId: Int?,
        @SerializedName("country")
        val country: String?,
        @SerializedName("city_id")
        val cityId: Int?,
        @SerializedName("city")
        val city: String?,
        @SerializedName("categories")
        val categories: List<Category?>?,
        @SerializedName("type_id")
        val typeId: Int?,
        @SerializedName("type")
        val type: Type?
    )

    data class Image(
        @SerializedName("id")
        val id: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("preview")
        val preview: String?,
        @SerializedName("placeholder_color")
        val placeholderColor: String?,
        @SerializedName("width")
        val width: Int?,
        @SerializedName("height")
        val height: Int?
    )

    data class Category(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("url")
        val url: String?
    )

    data class Type(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?
    )

    fun toDomain() = conference.run {
        ConferenceLandingItem(
            categories = categories?.mapNotNull { it?.name } ?: emptyList(),
            city = city ?: "",
            country = country ?: "",
            endDate = createConferenceDate(endDate),
            format = format?.toDomain() ?: ConferenceFormat.UNCONFINED,
            id = id ?: return@run null,
            imageSrc = image?.url,
            name = name ?: "",
            startDate = createConferenceDate(startDate),
            status = status?.toDomain() ?: ConferenceStatus.UNCONFINED,
            statusTitle = statusTitle ?: "",
            isNewMonth = false,
            isOneDay = oneday == 1,
            position = ""
        )
    }

    fun createConferenceDate(inputDate: String?): ConferenceDate {
        if (inputDate.isNullOrEmpty()) return ConferenceDate.empty()
        return try {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = formatter.parse(inputDate)
            ConferenceDate(
                day = SimpleDateFormat("dd", Locale.getDefault()).format(date),
                monthShort = SimpleDateFormat("MMM", Locale.ENGLISH).format(date).uppercase(),
                monthYear = "",
                date = inputDate
            )
        } catch (_: Throwable) {
            ConferenceDate.empty()
        }
    }
}
