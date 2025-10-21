package com.vazdautsan.conferences.data.dto

import com.google.gson.annotations.SerializedName
import com.vazdautsan.conferences.domain.model.conferences.ConferenceFormat

enum class ConferenceFormatDto {
    @SerializedName("online")
    ONLINE,
    @SerializedName("offline")
    OFFLINE
}

fun ConferenceFormatDto.toDomain() = when (this) {
    ConferenceFormatDto.ONLINE -> ConferenceFormat.ONLINE
    ConferenceFormatDto.OFFLINE -> ConferenceFormat.OFFLINE
}