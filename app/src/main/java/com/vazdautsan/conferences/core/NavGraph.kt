package com.vazdautsan.conferences.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vazdautsan.conferences.features.conferenses.navigation.ConferencesNavGraph
import com.vazdautsan.conferences.features.conferenses.navigation.conferencesNavGraph

@Composable
internal fun NavGraph(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ConferencesNavGraph
    ) {
        conferencesNavGraph(navController = navController)
    }
}