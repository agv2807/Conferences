package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent

import androidx.lifecycle.ViewModel
import com.vazdautsan.conferences.domain.model.base.mapResult
import com.vazdautsan.conferences.domain.use_case.GetConferences
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.model.toUi
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view.ConferencesState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class ConferencesViewModel(
    private val getPagingConferences: GetConferences
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
        repeatOnSubscription {
            val result = getPagingConferences().mapResult { result -> result.map { it.toUi() } }
            reduce { state.copy(conferences = result) }
        }
    }

    private fun openConference(id: Int) = intent {
        postSideEffect(ConferencesSideEffect.OpenConference(id))
    }
}