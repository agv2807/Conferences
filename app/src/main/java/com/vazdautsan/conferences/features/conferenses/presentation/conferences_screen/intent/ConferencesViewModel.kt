package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent

import androidx.lifecycle.ViewModel
import com.vazdautsan.conferences.domain.paging.mapPaging
import com.vazdautsan.conferences.domain.use_case.GetPagingConferences
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.model.toUi
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view.ConferencesState
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
        getPagingConferences().collect { conferences ->
            reduce { state.copy(conferences = conferences.mapPaging { it.toUi() }) }
        }
    }

    private fun openConference(id: Int) = intent {
        postSideEffect(ConferencesSideEffect.OpenConference(id))
    }
}