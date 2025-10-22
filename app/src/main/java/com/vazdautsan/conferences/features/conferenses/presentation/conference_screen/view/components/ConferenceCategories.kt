package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vazdautsan.conferences.ui.theme.Colors

@Composable
fun ConferenceCategories(
    modifier: Modifier = Modifier,
    categories: List<String>
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEach {
            Text(
                modifier = Modifier
                    .background(Colors.grayBg, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 4.5.dp),
                text = it,
                color = Colors.buttonConf,
                fontSize = 11.sp,
                fontWeight = FontWeight(600),
                lineHeight = 15.4.sp
            )
        }
    }
}