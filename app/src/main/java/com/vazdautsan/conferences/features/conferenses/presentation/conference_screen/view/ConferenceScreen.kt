package com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vazdautsan.conferences.R
import com.vazdautsan.conferences.domain.model.base.Result
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent.ConferenceAction
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.intent.ConferenceViewModel
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils.CollectSideEffect
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.utils.ConferenceNavAction
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view.components.ConferenceCategories
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view.components.ConferenceDatePosition
import com.vazdautsan.conferences.features.conferenses.presentation.conference_screen.view.components.ConferenceTitle
import com.vazdautsan.conferences.features.utils.navigationBarHeightDp
import com.vazdautsan.conferences.ui.theme.Colors
import de.charlex.compose.HtmlText
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState

@Serializable
data class ConferenceDestination(val id: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConferenceScreen(
    modifier: Modifier = Modifier,
    conferenceId: Int,
    viewModel: ConferenceViewModel = koinViewModel(parameters = { parametersOf(conferenceId) }),
    onNavAction: (ConferenceNavAction) -> Unit
) {
    val state by viewModel.collectAsState()
    CollectSideEffect(viewModel = viewModel, onNavAction = onNavAction)
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.dispatch(ConferenceAction.BackClick) }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icon_go_back),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        contentWindowInsets = WindowInsets()
    ) {
        ConferenceContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = state,
            onAction = viewModel::dispatch
        )
    }
}

@Composable
private fun ConferenceContent(
    modifier: Modifier = Modifier,
    state: ConferenceState,
    onAction: (ConferenceAction) -> Unit
) {
    when (state.conference) {
        is Result.Success -> {
            val conference = state.conference.data
            Column(modifier = modifier.verticalScroll(rememberScrollState())) {
                ConferenceTitle(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 12.dp),
                    type = conference.type,
                    name = conference.name,
                    imageUrl = conference.imageUrl
                )
                Spacer(modifier = Modifier.height(20.dp))
                ConferenceCategories(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    categories = conference.categories
                )
                Spacer(modifier = Modifier.height(20.dp))
                ConferenceDatePosition(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    date = conference.startDate,
                    position = conference.position
                )
                Spacer(modifier = Modifier.height(28.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { onAction(ConferenceAction.RegistrationClick) },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Colors.buttonArtConf,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.registration),
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        lineHeight = 22.4.sp
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = stringResource(R.string.about_event),
                    color = Colors.blackText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 25.2.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                HtmlText(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = conference.description,
                    color = Colors.blackText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 24.sp
                )
                Spacer(modifier = Modifier.height(navigationBarHeightDp()))
            }
        }

        else -> Unit
    }
}