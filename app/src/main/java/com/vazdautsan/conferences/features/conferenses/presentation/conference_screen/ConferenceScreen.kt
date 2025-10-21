package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils.CollectSideEffect
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils.ConferenceNavAction
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState

@Serializable
data class ConferenceDestination(val id: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConferenceScreen(
    modifier: Modifier = Modifier,
    conferenceId: Int,
    viewModel: ConferenceViewModel = koinViewModel(parameters = { parametersOf(conferenceId) }),
    onNavAction: (ConferenceNavAction) -> Unit
) {
    val state by viewModel.collectAsState()
    CollectSideEffect(viewModel = viewModel, onNavAction = onNavAction)
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.dispatch(ConferenceAction.BackClick) }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icon_go_back),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        contentWindowInsets = WindowInsets()
    ) {
        ConferenceContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = state,
            onAction = viewModel::dispatch
        )
    }
}

@Composable
private fun ConferenceContent(
    modifier: Modifier = Modifier,
    state: ConferenceState,
    onAction: (ConferenceAction) -> Unit
) {
}