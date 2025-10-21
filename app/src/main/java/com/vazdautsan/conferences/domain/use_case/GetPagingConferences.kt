package com.vazdautsan.conferences.domain.use_case

import com.vazdautsan.conferences.domain.helper.MonthNamesProvider
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.paging.PagingData
import com.vazdautsan.conferences.domain.paging.mapPagingFlow
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GetPagingConferences(
    private val conferencesRepository: ConferencesRepository,
    private val monthNamesProvider: MonthNamesProvider
) {
    suspend fun execute(): Flow<PagingData<ConferenceLandingItem>> {
        var previousMonth: Int? = null
        return conferencesRepository.getConferences().mapPagingFlow {
            val currentMonth = parseYearMonth(it.startDate.date)
            it.copy(
                isNewMonth = currentMonth != previousMonth,
                startDate = it.startDate.copy(
                    monthYear = createMonthYear(it.startDate.date)
                )
            ).also {
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

    private fun createMonthYear(inputDate: String): String {
        val months = monthNamesProvider.getMonthsArray()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return try {
            val date = formatter.parse(inputDate)
            val calendar = Calendar.getInstance()
            calendar.time = date
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            "${months[month]}, $year"
        } catch (_: Throwable) {
            ""
        }
    }
}