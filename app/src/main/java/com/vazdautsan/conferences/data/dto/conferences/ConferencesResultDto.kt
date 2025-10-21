package com.vazdautsan.conferences.data.dto.conferences

import com.google.gson.annotations.SerializedName

data class ConferencesResultDto(
    @SerializedName("result")
    val result: List<ConferenceLandingItemDto>
)