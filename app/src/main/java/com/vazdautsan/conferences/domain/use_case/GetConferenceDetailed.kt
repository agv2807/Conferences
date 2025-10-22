package com.vazdautsan.conferences.domain.use_case

import com.vazdautsan.conferences.domain.helper.ConferencePositionHelper
import com.vazdautsan.conferences.domain.helper.DaysPluralProvider
import com.vazdautsan.conferences.domain.model.base.mapResult
import com.vazdautsan.conferences.domain.repository.ConferencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class GetConferenceDetailed(
    private val conferencesRepository: ConferencesRepository,
    private val daysPluralProvider: DaysPluralProvider,
    private val conferencePositionHelper: ConferencePositionHelper
) {
    suspend fun execute(id: Int) = conferencesRepository.getConferenceDetailed(id).mapResult {
        it.copy(
            startDate = convertDate(it.startDate, it.endDate),
            position = conferencePositionHelper.getPosition(
                format = it.format,
                city = it.city,
                country = it.country
            )
        )
    }

    private fun convertDate(inputStartDate: String, inputEndDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        val startDate = inputFormat.parse(inputStartDate) ?: return ""
        val endDate = inputFormat.parse(inputEndDate) ?: return ""
        val formattedStartDate = outputFormat.format(startDate)
        val diffInMillis = endDate.time - startDate.time
        val days = TimeUnit.DAYS.convert(
            diffInMillis,
            TimeUnit.MILLISECONDS
        ) + 1
        return "$formattedStartDate, $days ${days.daysString()}"
    }

    private fun Long.daysString(): String {
        return daysPluralProvider.getDayPlural((this % 10).toInt())
    }

    suspend operator fun invoke(id: Int) = withContext(Dispatchers.Default) { execute(id) }
}