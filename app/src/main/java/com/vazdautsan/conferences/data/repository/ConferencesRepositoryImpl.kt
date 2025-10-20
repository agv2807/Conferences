package com.vazdautsan.conferences.data.repository

import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.Pager
import com.vazdautsan.conferences.domain.paging.PagerConfig
import com.vazdautsan.conferences.domain.paging.PagingData
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import kotlinx.coroutines.flow.Flow

class ConferencesRepositoryImpl : ConferencesRepository {
    override suspend fun getConferences(): Flow<PagingData<ConferenceLandingItem>> {
        return Pager(
            config = PagerConfig(perPage = 20),
            load = { page, perPage -> emptyList<ConferenceLandingItem>() }
        ).flow
    }
}