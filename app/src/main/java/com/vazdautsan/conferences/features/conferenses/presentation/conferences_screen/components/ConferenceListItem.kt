package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.ui.theme.Colors

@Composable
internal fun ConferenceListItem(
    modifier: Modifier = Modifier,
    conference: ConferenceLandingItem
) {
    Column(modifier = modifier) {
        if (conference.isNewMonth) {
            Text(
                modifier = Modifier.padding(bottom = 24.dp, start = 16.dp),
                text = "New Month",
                color = Colors.blackText,
                fontWeight = FontWeight(600),
                fontSize = 18.sp,
                lineHeight = 32.sp
            )
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Colors.grayBg)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = conference.name,
                color = Colors.buttonConf,
                fontSize = 24.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ConferenceTime(
                modifier = Modifier.fillMaxWidth(),
                imageSrc = conference.imageSrc,
                start = conference.startDate,
                end = conference.endDate
            )
            Spacer(modifier = Modifier.height(24.dp))
            ConferenceBadges(badges = conference.categories)
            Spacer(modifier = Modifier.height(16.dp))
            ConferencePosition(
                format = conference.format,
                city = conference.city,
                country = conference.country
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ConferenceTime(
    modifier: Modifier = Modifier,
    imageSrc: String?,
    start: String,
    end: String
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Colors.buttonArtConf.copy(alpha = 0.04f)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .height(156.dp),
            model = imageSrc,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "29",
                    color = Colors.blackText,
                    fontSize = 40.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = "Jul",
                    color = Colors.blackText.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400)
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "-",
                color = Colors.blackText,
                fontSize = 40.sp,
                fontWeight = FontWeight(300)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "29",
                    color = Colors.blackText,
                    fontSize = 40.sp,
                    fontWeight = FontWeight(300)
                )
                Text(
                    text = "Jul",
                    color = Colors.blackText.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Composable
private fun ConferenceBadges(
    modifier: Modifier = Modifier,
    badges: List<String>
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        badges.forEach {
            Text(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 4.5.dp),
                text = it,
                color = Colors.buttonConf,
                fontSize = 11.sp,
                fontWeight = FontWeight(600)
            )
        }
    }
}

@Composable
private fun ConferencePosition(
    modifier: Modifier = Modifier,
    format: String,
    city: String,
    country: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_octicon_location_16),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (format == "online") stringResource(R.string.online) else {
                buildString {
                    append(country)
                    append(", ")
                    append(city)
                }
            },
            color = Colors.buttonConf,
            fontWeight = FontWeight(400),
            fontSize = 14.sp
        )
    }
}