package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vazdautsan.conferences.ui.theme.Colors

@Composable
fun ConferenceTitle(
    modifier: Modifier = Modifier,
    type: String,
    name: String,
    imageUrl: String?
) {
    Column(modifier = modifier) {
        Text(
            text = type,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 22.4.sp,
            color = Colors.blackText
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            lineHeight = 28.8.sp,
            color = Colors.blackText
        )
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(328f / 219f)
                .clip(RoundedCornerShape(16.dp)),
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}