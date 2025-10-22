package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent.ConferencesAction
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.intent.ConferencesViewModel
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.view.components.ConferenceListItem
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.utils.CollectSideEffect
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.utils.ConferencesNavAction
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState

@Serializable
data object ConferencesDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ConferencesScreen(
    modifier: Modifier = Modifier,
    onNavAction: (ConferencesNavAction) -> Unit,
    viewModel: ConferencesViewModel = koinViewModel()
) {
    val state by viewModel.collectAsState()
    CollectSideEffect(viewModel = viewModel, onNavAction = onNavAction)
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.conferences))
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icon_go_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icon_hugeicons_customer_support),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        contentWindowInsets = WindowInsets()
    ) {
        ConferencesContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = state,
            onAction = viewModel::dispatch
        )
    }
}

@Composable
private fun ConferencesContent(
    modifier: Modifier = Modifier,
    state: ConferencesState,
    onAction: (ConferencesAction) -> Unit
) {
    val density = LocalDensity.current
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = with(density) {
            WindowInsets.navigationBars.getBottom(
                density
            ).toDp()
        })
    ) {
        items(state.conferences.itemCount()) {
            val conference = state.conferences[it]
            ConferenceListItem(
                conference = conference,
                onClick = { onAction(ConferencesAction.ConferenceClick(conference.id)) }
            )
        }
    }
}