package com.sb.equalizer.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sb.core.R
import com.sb.core.composable.Preview
import com.sb.core.resources.AppRes

@Composable
fun CompressorEffect(
    enabled: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.compressor_effect),
            color = AppRes.colors.primary,
            fontSize = 18.sp,
            style = AppRes.type.gilroySemibold
        )
        Switch(
            checked = enabled,
            onCheckedChange = onCheckedChanged,
            thumbContent = {
                Box(
                    Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(AppRes.colors.primary)
                )
            },
            colors = SwitchDefaults.colors().copy(
                checkedThumbColor = Color.Transparent,
                uncheckedThumbColor = Color.Transparent,
                checkedTrackColor = AppRes.colors.secondary,
                uncheckedTrackColor = AppRes.colors.backgroundContrast,
                uncheckedBorderColor = AppRes.colors.secondary
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun CompressorEffectPreview() {
    var state by remember { mutableStateOf(false) }
    Preview {
        CompressorEffect(
            enabled = state,
            onCheckedChanged = { state = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
