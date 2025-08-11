package com.sb.equalizer.presentation.ui.composable

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sb.core.R
import com.sb.core.composable.Preview
import com.sb.core.resources.AppRes

@Composable
fun GainAmplitude(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = stringResource(R.string.gain_amplitude),
            color = AppRes.colors.primary,
            fontSize = 12.sp,
            style = AppRes.type.gilroySemibold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "-10dB",
                color = AppRes.colors.secondary,
                fontSize = 8.sp,
                style = AppRes.type.gilroyMedium
            )
            CustomSlider(
                modifier = Modifier.weight(1f),
                value = value,
                onValueChange = onValueChange,
                valueRange = -10f..10f,
                orientation = Orientation.Horizontal,
            )
            Text(
                text = "+10dB",
                color = AppRes.colors.secondary,
                fontSize = 8.sp,
                style = AppRes.type.gilroyMedium
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun GainAmplitudePreview() {
    var value by remember { mutableFloatStateOf(0f) }
    Preview {
        GainAmplitude(
            value = value,
            onValueChange = { value = it }
        )
    }
}
