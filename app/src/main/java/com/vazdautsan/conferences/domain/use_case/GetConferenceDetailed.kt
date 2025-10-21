package com.vazdautsan.conferences.domain.use_case

import com.vazdautsan.conferences.domain.repository.ConferencesRepository

class GetConferenceDetailed(
    private val conferencesRepository: ConferencesRepository
) {
    suspend fun execute(id: Int) = conferencesRepository.getConferenceDetailed(id)

    suspend operator fun invoke(id: Int) = execute(id)
}