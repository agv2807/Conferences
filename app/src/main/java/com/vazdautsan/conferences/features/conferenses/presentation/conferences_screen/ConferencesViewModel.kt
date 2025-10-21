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
        when (action) {
            is ConferencesAction.ConferenceClick -> {
                openConference(action.id)
            }
        }
    }

    private fun loadConferences() = intent {
        getPagingConferences().collect {
            reduce { state.copy(conferences = it) }
        }
    }

    private fun openConference(id: Int) = intent {
        postSideEffect(ConferencesSideEffect.OpenConference(id))
    }
}