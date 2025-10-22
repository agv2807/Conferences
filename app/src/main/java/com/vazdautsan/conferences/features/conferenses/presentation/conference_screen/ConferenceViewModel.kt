package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

import androidx.lifecycle.ViewModel
import com.vazdautsan.conferences.domain.model.base.successDataOrNull
import com.vazdautsan.conferences.domain.use_case.GetConferenceDetailed
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class ConferenceViewModel(
    private val conferenceId: Int,
    private val getConferenceDetailed: GetConferenceDetailed
) : ViewModel(), ContainerHost<ConferenceState, ConferenceSideEffect> {

    override val container = container<ConferenceState, ConferenceSideEffect>(ConferenceState())

    init {
        loadConference()
    }

    fun dispatch(action: ConferenceAction) {
        when (action) {
            ConferenceAction.BackClick -> {
                navigateBack()
            }

            ConferenceAction.RegistrationClick -> {
                openRegistration()
            }
        }
    }

    private fun navigateBack() = intent {
        postSideEffect(ConferenceSideEffect.NavigateBack)
    }

    private fun loadConference() = intent {
        repeatOnSubscription {
            val result = getConferenceDetailed(conferenceId)
            reduce { state.copy(conference = result) }
        }
    }

    private fun openRegistration() = intent {
        val registerUrl = state.conference.successDataOrNull()?.registerUrl ?: return@intent
        postSideEffect(ConferenceSideEffect.OpenRegistration(registerUrl))
    }
}