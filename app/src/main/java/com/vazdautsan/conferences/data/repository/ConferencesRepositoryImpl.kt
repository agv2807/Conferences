package com.vazdautsan.conferences.data.repository

import android.util.Log
import com.vazdautsan.conferences.data.rds.ConferencesRds
import com.vazdautsan.conferences.data.utils.safeApiCall
import com.vazdautsan.conferences.domain.model.base.successDataOrNull
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.Pager
import com.vazdautsan.conferences.domain.paging.PagerConfig
import com.vazdautsan.conferences.domain.paging.PagingData
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import kotlinx.coroutines.flow.Flow

class ConferencesRepositoryImpl(
    private val conferencesRds: ConferencesRds
) : ConferencesRepository {
    override suspend fun getConferences(): Flow<PagingData<ConferenceLandingItem>> {
        return Pager(
            config = PagerConfig(perPage = 20),
            load = { page, perPage ->
                safeApiCall {
                    conferencesRds.getConferences(
                        page,
                        perPage
                    )
                }.also { Log.d("safmasfkmasf", "$it") }.successDataOrNull()?.result?.mapNotNull { it.toDomain() } ?: emptyList()
            }
        ).flow
    }
}