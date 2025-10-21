package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen

import androidx.lifecycle.ViewModel
import com.vazdautsan.conferences.domain.use_case.GetPagingConferences
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class ConferencesViewModel(
    private val getPagingConferences: GetPagingConferences
) : ViewModel(), ContainerHost<ConferencesState, ConferencesSideEffect> {
    override val container = container<ConferencesState, ConferencesSideEffect>(ConferencesState())

    init {
        loadConferences()
    }

    fun dispatch(action: ConferencesAction) {

    }

    private fun loadConferences() = intent {
        getPagingConferences().collect {
            reduce { state.copy(conferences = it) }
        }
    }
}