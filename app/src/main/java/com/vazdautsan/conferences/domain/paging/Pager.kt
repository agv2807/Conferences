package com.vazdautsan.conferences.domain.paging

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Pager<T : Any>(
    val config: PagerConfig,
    val load: suspend (Int, Int) -> List<T>,
) : PagingDataActions {

    private val mPagingData = PagingData<T>(this)

    private val pagingData = MutableStateFlow(mPagingData)
    val flow = pagingData.asStateFlow()

    private var fetchJob: Job? = null

    private var page = config.startPage

    private fun fetchNewData() {
        if (fetchJob?.isActive == false || fetchJob == null) {
            fetchJob = CoroutineScope(Dispatchers.IO).launch {
                if (config.perPage != 0 && mPagingData.status == PagingData.Status.IDLE) {
                    setPagerStatus(PagingData.Status.LOADING)
                    notifyPagerChanged()
                    try {
                        val result = load(page, config.perPage)
                        page++
                        addNewItems(result)
                        setPagerStatus(
                            if (result.isEmpty()) PagingData.Status.ENDED
                            else PagingData.Status.IDLE
                        )
                    } catch (_: Throwable) {
                        setPagerStatus(PagingData.Status.ERROR)
                    }
                    notifyPagerChanged()
                }
            }
        }
    }

    private fun setPagerStatus(status: PagingData.Status) {
        mPagingData.setStatus(status)
    }

    private fun addNewItems(items: List<T>) {
        mPagingData.setItems(newItems = items)
    }

    private suspend fun notifyPagerChanged() {
        val newData = PagingData<T>(callback = this).apply {
            replaceItems(mPagingData.getList())
            setStatus(mPagingData.status)
        }
        pagingData.emit(newData)
    }

    override suspend fun onRefreshCurrentData() {
        try {
            val refreshedList = load(1, mPagingData.itemCount())
            mPagingData.replaceItems(refreshedList)
        } catch (_: Throwable) {
            setPagerStatus(PagingData.Status.ERROR)
        }
        notifyPagerChanged()
    }

    override fun onEndReached() {
        fetchNewData()
    }

    init {
        fetchNewData()
    }
}