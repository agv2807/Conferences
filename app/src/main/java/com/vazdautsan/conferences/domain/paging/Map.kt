package com.vazdautsan.conferences.domain.paging

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <T : Any, R : Any> PagingData<T>.mapPaging(transform: (value: T) -> R): PagingData<R> {
    return PagingData(
        previousItems = this@mapPaging.getList().map { transform(it) },
        newStatus = this.status,
        onNeedLoad = this.callback
    )
}

inline fun <T : Any, R : Any> Flow<PagingData<T>>.mapPagingFlow(crossinline transform: (value: T) -> R): Flow<PagingData<R>> =
    this.map {
        it.mapPaging { transform(it) }
    }