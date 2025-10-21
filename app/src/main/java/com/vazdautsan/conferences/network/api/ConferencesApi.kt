package com.vazdautsan.conferences.network.api

import com.vazdautsan.conferences.data.dto.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse
import retrofit2.http.GET

interface ConferencesApi {
    @GET("api_ios_test/list?api_key=DMwdj29q@S29shslok2")
    suspend fun getConferences(page: Int, perPage: Int): ServerResponse<ConferencesResultDto>
}