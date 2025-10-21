package com.vazdautsan.conferences.data.dto.conferences

import com.google.gson.annotations.SerializedName
import com.vazdautsan.conferences.domain.model.conferences.ConferenceStatus

enum class ConferenceStatusDto {
    @SerializedName("publish")
    PUBLISH,
    @SerializedName("canceled")
    CANCELED
}

fun ConferenceStatusDto.toDomain() = when (this) {
    ConferenceStatusDto.PUBLISH -> ConferenceStatus.PUBLISH
    ConferenceStatusDto.CANCELED -> ConferenceStatus.CANCELED
}