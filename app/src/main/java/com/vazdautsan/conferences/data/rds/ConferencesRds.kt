package com.vazdautsan.conferences.data.rds

import com.vazdautsan.conferences.data.dto.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse

interface ConferencesRds {
    suspend fun getConferences(page: Int, perPage: Int): ServerResponse<ConferencesResultDto>
}