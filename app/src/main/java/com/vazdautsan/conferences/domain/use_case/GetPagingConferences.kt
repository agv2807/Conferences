package com.vazdautsan.conferences.domain.use_case

import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.PagingData
import com.vazdautsan.conferences.domain.paging.mapPagingFlow
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GetPagingConferences(
    private val conferencesRepository: ConferencesRepository
) {
    suspend fun execute(): Flow<PagingData<ConferenceLandingItem>> {
        var previousMonth: Int? = null
        return conferencesRepository.getConferences().mapPagingFlow {
            val currentMonth = parseYearMonth(it.startDate)
            it.copy(isNewMonth = currentMonth != previousMonth).also {
                previousMonth = currentMonth
            }
        }
    }

    suspend operator fun invoke() = execute()

    private fun parseYearMonth(dateString: String): Int? {
        return try {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            format.isLenient = false
            val date = format.parse(dateString.split("T").first()) ?: return null

            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.get(Calendar.YEAR) * 100 + (calendar.get(Calendar.MONTH) + 1)
        } catch (_: Exception) {
            null
        }
    }
}