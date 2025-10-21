package com.vazdautsan.conferences.data.dto.server_response

import com.google.gson.annotations.SerializedName

data class ServerResponse<T>(
    @SerializedName("error")
    val error: String?,
    @SerializedName("data")
    val data: T?
)