package com.vazdautsan.conferences.features.conferenses.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.ConferenceDestination
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.ConferenceScreen
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils.ConferenceNavAction
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesDestination
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesScreen
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.utils.ConferencesNavAction
import kotlinx.serialization.Serializable

@Serializable
data object ConferencesNavGraph

internal fun NavGraphBuilder.conferencesNavGraph(
    navController: NavController
) {
    navigation<ConferencesNavGraph>(
        startDestination = ConferencesDestination
    ) {
        composable<ConferencesDestination> {
            ConferencesScreen(
                modifier = Modifier.fillMaxSize(),
                onNavAction = { action ->
                    when (action) {
                        is ConferencesNavAction.Conference -> {
                            navController.navigate(ConferenceDestination(action.id))
                        }
                    }
                }
            )
        }

        composable<ConferenceDestination> {
            ConferenceScreen(
                modifier = Modifier.fillMaxSize(),
                onNavAction = { action ->
                    when (action) {
                        ConferenceNavAction.Back -> {
                            navController.navigateUp()
                        }
                    }
                },
                conferenceId = it.toRoute<ConferenceDestination>().id
            )
        }
    }
}