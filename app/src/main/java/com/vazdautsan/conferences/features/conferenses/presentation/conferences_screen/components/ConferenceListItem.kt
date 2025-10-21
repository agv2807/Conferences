package com.vazdautsan.conferences.features.conferenses.presentation.conferences_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.vazdautsan.conferences.domain.model.conferences.ConferenceFormat
import com.vazdautsan.conferences.domain.model.conferences.ConferenceLandingItem
import com.vazdautsan.conferences.domain.model.conferences.ConferenceStatus
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
                lineHeight = 25.2.sp
            )
        }
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(conference.status.getBackground())
                .padding(horizontal = 16.dp)
        ) {
            if (conference.status == ConferenceStatus.CANCELED) {
                Spacer(modifier = Modifier.height(10.dp))
                CancelledBadge(text = conference.statusTitle)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = conference.name,
                color = Colors.buttonConf,
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                lineHeight = 28.8.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            ConferenceTime(
                modifier = Modifier.fillMaxWidth(),
                imageSrc = conference.imageSrc,
                start = conference.startDate,
                end = conference.endDate,
                status = conference.status
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
    end: String,
    status: ConferenceStatus
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(status.getTimeBackground()),
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
                    fontWeight = FontWeight(300),
                    lineHeight = 56.sp
                )
                Text(
                    text = "Jul",
                    color = Colors.blackText.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.8.sp
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "-",
                color = Colors.blackText,
                fontSize = 40.sp,
                fontWeight = FontWeight(300),
                lineHeight = 56.sp
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "29",
                    color = Colors.blackText,
                    fontSize = 40.sp,
                    fontWeight = FontWeight(300),
                    lineHeight = 56.sp
                )
                Text(
                    text = "Jul",
                    color = Colors.blackText.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.8.sp
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
                fontWeight = FontWeight(600),
                lineHeight = 15.4.sp
            )
        }
    }
}

@Composable
private fun ConferencePosition(
    modifier: Modifier = Modifier,
    format: ConferenceFormat,
    city: String,
    country: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.icon_octicon_location_16),
            contentDescription = null,
            tint = Colors.blackText
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = if (format == ConferenceFormat.ONLINE) stringResource(R.string.online) else {
                buildString {
                    append(country)
                    append(", ")
                    append(city)
                }
            },
            color = Colors.buttonConf,
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 22.4.sp
        )
    }
}

@Composable
private fun CancelledBadge(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.Red,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ph_lightning_bold),
            contentDescription = null,
            tint = Color.Red
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = text,
            color = Color.Red,
            fontWeight = FontWeight(600),
            fontSize = 11.sp,
            lineHeight = 15.4.sp
        )
    }
}

private fun ConferenceStatus.getBackground() = when (this) {
    ConferenceStatus.PUBLISH -> Colors.grayBg
    ConferenceStatus.CANCELED -> Color.Red.copy(alpha = 0.1f)
    ConferenceStatus.UNCONFINED -> Colors.grayBg
}

private fun ConferenceStatus.getTimeBackground() = when (this) {
    ConferenceStatus.PUBLISH -> Colors.buttonArtConf.copy(alpha = 0.04f)
    ConferenceStatus.CANCELED -> Color.Red.copy(alpha = 0.06f)
    ConferenceStatus.UNCONFINED -> Colors.buttonArtConf.copy(alpha = 0.04f)
}