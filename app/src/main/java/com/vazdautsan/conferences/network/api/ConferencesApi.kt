package com.vazdautsan.conferences.network.api

import com.vazdautsan.conferences.data.dto.conferences.ConferenceDetailedDto
import com.vazdautsan.conferences.data.dto.conferences.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse
import retrofit2.http.GET

interface ConferencesApi {
    @GET("api_ios_test/list")
    suspend fun getConferences(): ServerResponse<ConferencesResultDto>

    @GET("api_ios_test/view")
    suspend fun getConference(): ServerResponse<ConferenceDetailedDto>
}