package com.vazdautsan.conferences.data.rds

import com.vazdautsan.conferences.data.dto.conferences.ConferenceDetailedDto
import com.vazdautsan.conferences.data.dto.conferences.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse

interface ConferencesRds {
    suspend fun getConferences(): ServerResponse<ConferencesResultDto>

    suspend fun getConference(id: Int): ServerResponse<ConferenceDetailedDto>
}