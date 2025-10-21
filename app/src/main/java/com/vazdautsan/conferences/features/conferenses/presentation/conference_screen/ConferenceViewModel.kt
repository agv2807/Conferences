package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class ConferenceViewModel : ViewModel(), ContainerHost<ConferenceState, ConferenceSideEffect> {

    override val container = container<ConferenceState, ConferenceSideEffect>(ConferenceState())

    fun dispatch(action: ConferenceAction) {
        when (action) {
            ConferenceAction.BackClick -> {
                navigateBack()
            }
        }
    }

    private fun navigateBack() = intent {
        postSideEffect(ConferenceSideEffect.NavigateBack)
    }
}