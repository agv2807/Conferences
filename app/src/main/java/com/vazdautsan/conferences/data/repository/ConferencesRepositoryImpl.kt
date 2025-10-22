package com.vazdautsan.conferences.data.repository

import com.vazdautsan.conferences.data.rds.ConferencesRds
import com.vazdautsan.conferences.data.utils.safeApiCall
import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.domain.model.base.mapResult
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.repository.ConferencesRepository

class ConferencesRepositoryImpl(
    private val conferencesRds: ConferencesRds
) : ConferencesRepository {
    override suspend fun getConferences(): Result<List<ConferenceLandingItem>> {
        return safeApiCall { conferencesRds.getConferences() }.mapResult {
            it.result?.mapNotNull { it?.toDomain() } ?: emptyList()
        }
    }

    override suspend fun getConferenceDetailed(id: Int): Result<ConferenceDetailed> {
        return safeApiCall { conferencesRds.getConference(id) }.mapResult { it.toDomain() }
    }
}