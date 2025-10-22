package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.ui.theme.Colors

@Composable
fun ConferenceDatePosition(
    modifier: Modifier = Modifier,
    date: String,
    position: String
) {
    Column(modifier = modifier) {
        DatePositionItem(
            icon = ImageVector.vectorResource(R.drawable.icon_uil_schedule),
            text = date
        )
        Spacer(modifier = Modifier.height(10.dp))
        DatePositionItem(
            icon = ImageVector.vectorResource(R.drawable.icon_octicon_location_16),
            text = position
        )
    }
}

@Composable
private fun DatePositionItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Colors.buttonArtConf
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 25.6.sp,
            color = Colors.blackText
        )
    }
}