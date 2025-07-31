package com.sb.equalizer.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.sb.core.composable.ClickableIcon
import com.sb.core.composable.Loading
import com.sb.core.composable.Preview
import com.sb.core.resources.AppRes
import com.sb.domain.entity.Profile
import com.sb.equalizer.presentation.component.EqualizerComponent
import com.sb.equalizer.presentation.component.EqualizerStore
import com.sb.equalizer.presentation.ui.composable.ChannelCheckboxes
import com.sb.equalizer.presentation.ui.composable.CompressorEffect
import com.sb.equalizer.presentation.ui.composable.Equalizer
import com.sb.equalizer.presentation.ui.composable.GainAmplitude
import com.sb.equalizer.presentation.ui.composable.ProfilesDropDownMenu
import com.sb.equalizer.presentation.ui.composable.SaveDialog

@Composable
fun EqualizerContent(
    component: EqualizerComponent,
    modifier: Modifier = Modifier,
) {
    val state by component.equalizerStore.state.collectAsState()
    state?.let {
        EqualizerScreenContent(
            modifier = modifier.fillMaxSize(),
            state = it,
            dispatchIntent = component.equalizerStore::dispatchIntent
        )
    } ?: Loading()
}

@Composable
private fun EqualizerScreenContent(
    state: EqualizerStore.State,
    dispatchIntent: (EqualizerStore.Intent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.padding(vertical = 32.dp)) {
        var showSaveDialog by remember { mutableStateOf(false) }
        SaveDialog(
            profiles = state.profiles,
            show = showSaveDialog,
            onSave = { dispatchIntent(EqualizerStore.Intent.SaveNewProfile(it)) },
            onDismiss = { showSaveDialog = false }
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val hasDifference = state.selectedProfile.hasDifference(
                    amplitude = state.amplitude,
                    gains = state.frequencies.map { it.second },
                    leftChannel = state.leftChannelEnabled,
                    rightChannel = state.rightChannelEnabled,
                    compressorEnabled = state.compressorEnabled
                )
                val weight by animateFloatAsState(targetValue = if (hasDifference) 0.9f else 1f)
                ProfilesDropDownMenu(
                    modifier = Modifier
                        .fillMaxWidth(weight)
                        .animateContentSize(),
                    selectedProfile = state.selectedProfile,
                    list = state.profiles.filter { it.id != state.selectedProfile.id },
                    onSelected = { dispatchIntent(EqualizerStore.Intent.ChangeProfile(it)) },
                    onDelete = { dispatchIntent(EqualizerStore.Intent.DeleteProfile(it)) }
                )
                AnimatedVisibility(visible = hasDifference, enter = scaleIn(), exit = scaleOut()) {
                    ClickableIcon(
                        modifier = Modifier.weight(1f),
                        imageVector = AppRes.icons.save,
                        tint = AppRes.colors.secondary,
                        rippleRadius = 24.dp,
                        onClick = { showSaveDialog = true }
                    )
                }
            }
            Equalizer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                frequencies = state.frequencies,
                valueRange = -10f..10f,
                onGainChanged = { frequency, value ->
                    dispatchIntent(
                        EqualizerStore.Intent.FrequencyGainChanged(
                            frequency,
                            value
                        )
                    )
                }
            )
            GainAmplitude(
                modifier = Modifier.padding(horizontal = 16.dp),
                value = state.amplitude,
                onValueChange = { dispatchIntent(EqualizerStore.Intent.AmplitudeGainChanged(it)) }
            )
            ChannelCheckboxes(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                rightChannel = state.rightChannelEnabled,
                leftChannel = state.leftChannelEnabled,
                onLeftChannelChanged = { dispatchIntent(EqualizerStore.Intent.ChangeLeftChannel(it)) },
                onRightChannelChanged = { dispatchIntent(EqualizerStore.Intent.ChangeRightChannel(it)) }
            )
            CompressorEffect(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                enabled = state.compressorEnabled,
                onCheckedChanged = { dispatchIntent(EqualizerStore.Intent.EnableCompressor(it)) },
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun EqualizerContentPreview() {
    Preview {
        EqualizerScreenContent(
            state = EqualizerStore.State(
                selectedProfile = Profile.preview(),
                frequencies = listOf(
                    31 to 10f,
                    63 to 8f,
                    125 to 6f,
                    250 to 4f,
                    500 to 2f,
                    1000 to 0f,
                    2000 to -2f,
                    4000 to -4f,
                    8000 to -6f,
                    16000 to -8f
                ),
                amplitude = 0f,
                leftChannelEnabled = false,
                rightChannelEnabled = true,
                profiles = listOf(),
                compressorEnabled = true
            ),
            dispatchIntent = {}
        )
    }
}
