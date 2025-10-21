package com.vazdautsan.conferences.features.conferenses.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesDestination
import com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.ConferencesScreen
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
                onNavAction = {

                }
            )
        }
    }
}