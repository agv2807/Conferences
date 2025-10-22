package com.vazdautsan.conferences.domain.repository

import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem

interface ConferencesRepository {
    suspend fun getConferences(): Result<List<ConferenceLandingItem>>

    suspend fun getConferenceDetailed(id: Int): Result<ConferenceDetailed>
}