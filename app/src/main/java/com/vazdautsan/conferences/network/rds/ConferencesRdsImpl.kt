package com.vazdautsan.conferences.network.rds

import com.vazdautsan.conferences.data.dto.conferences.ConferenceDetailedDto
import com.vazdautsan.conferences.data.dto.conferences.ConferencesResultDto
import com.vazdautsan.conferences.data.dto.server_response.ServerResponse
import com.vazdautsan.conferences.data.rds.ConferencesRds
import com.vazdautsan.conferences.network.api.ConferencesApi

class ConferencesRdsImpl(private val conferencesApi: ConferencesApi) : ConferencesRds {
    override suspend fun getConferences(): ServerResponse<ConferencesResultDto> {
        return conferencesApi.getConferences()
    }

    override suspend fun getConference(id: Int): ServerResponse<ConferenceDetailedDto> {
        return conferencesApi.getConference()
    }
}