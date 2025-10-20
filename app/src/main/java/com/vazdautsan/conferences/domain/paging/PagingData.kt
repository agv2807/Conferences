package com.vazdautsan.conferences.domain.paging

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PagingData<T : Any>(
    val callback: PagingDataActions
) {
    private val items = mutableListOf<T>()

    var status = Status.IDLE
        private set

    private val coroutine = CoroutineScope(Dispatchers.IO)

    constructor(
        previousItems: List<T>,
        onNeedLoad: PagingDataActions
    ) : this(callback = onNeedLoad) {
        setItems(previousItems)
    }

    constructor(
        previousItems: List<T>,
        newStatus: Status,
        onNeedLoad: PagingDataActions
    ) : this(callback = onNeedLoad) {
        setItems(previousItems)
        setStatus(newStatus)
    }

    operator fun get(index: Int): T = getItem(index)

    fun getItem(index: Int): T {
        val item = items[index]
        if (index == items.lastIndex) {
            loadNewData()
        }
        return item
    }

    fun getList(): List<T> = items.toList()

    fun itemCount() = items.count()

    internal fun setItems(newItems: List<T>) {
        items.addAll(newItems)
    }

    /**
     * Функция нужна при рефреше всех загруженных данных
     * Желательно, чтобы размер нового списка совпадал с тем,
     * что уже загружен
     */
    internal fun replaceItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
    }

    internal fun setStatus(newStatus: Status) {
        status = newStatus
    }


    private fun loadNewData() {
        callback.onEndReached()
    }

    fun refreshAllData() {
        coroutine.launch {
            callback.onRefreshCurrentData()
        }
    }

    fun loadNextPage() {
        loadNewData()
    }

    fun isNotLoaded() = itemCount() == 0 && status == Status.IDLE

    override fun toString(): String {
        return "PagingData(items = ${getList()}, status = $status)"
    }

    companion object {
        fun <T : Any> empty(): PagingData<T> {
            return PagingData(
                previousItems = emptyList(),
                onNeedLoad = object : PagingDataActions {
                    override fun onEndReached() {}
                    override suspend fun onRefreshCurrentData() {}
                }
            )
        }
    }

    enum class Status {
        LOADING, IDLE, ENDED, ERROR
    }
}