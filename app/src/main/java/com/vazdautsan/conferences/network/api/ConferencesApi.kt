package com.vazdautsan.conferences.network.api

import com.vazdautsan.conferences.data.dto.conferences.ConferenceDetailedDto
import com.vazdautsan.conferences.data.dto.conferences.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ConferencesApi {
    @GET("api_ios_test/list")
    suspend fun getConferences(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int
    ): ServerResponse<ConferencesResultDto>

    @GET("api_ios_test/view")
    suspend fun getConference(): ServerResponse<ConferenceDetailedDto>
}