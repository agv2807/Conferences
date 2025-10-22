package com.vazdautsan.conferences.features.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun navigationBarHeightDp(): Dp {
    val density = LocalDensity.current
    return with(density) {
        WindowInsets.navigationBars.getBottom(this).toDp()
    }
}