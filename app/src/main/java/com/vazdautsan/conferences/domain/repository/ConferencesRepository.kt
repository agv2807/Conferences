package com.vazdautsan.conferences.domain.repository

import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.domain.model.conferences.ConferenceDetailed
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface ConferencesRepository {
    suspend fun getConferences(): Flow<PagingData<ConferenceLandingItem>>

    suspend fun getConferenceDetailed(id: Int): Result<ConferenceDetailed>
}