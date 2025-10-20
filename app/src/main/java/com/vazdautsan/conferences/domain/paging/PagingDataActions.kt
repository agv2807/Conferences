package com.vazdautsan.conferences.domain.paging

interface PagingDataActions {
    fun onEndReached()
    suspend fun onRefreshCurrentData()
}