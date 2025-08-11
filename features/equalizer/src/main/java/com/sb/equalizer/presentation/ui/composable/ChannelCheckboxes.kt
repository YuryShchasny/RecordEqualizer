package com.sb.equalizer.presentation.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
fun ChannelCheckboxes(
    modifier: Modifier = Modifier,
    rightChannel: Boolean,
    leftChannel: Boolean,
    onLeftChannelChanged: (Boolean) -> Unit,
    onRightChannelChanged: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = leftChannel,
                onCheckedChange = {
                    onLeftChannelChanged(it)
                },
                colors = CheckboxDefaults.colors().copy(
                    checkedCheckmarkColor = AppRes.colors.background,
                    checkedBoxColor = AppRes.colors.secondary,
                    checkedBorderColor = AppRes.colors.secondary,
                    uncheckedBorderColor = AppRes.colors.secondary
                ),
            )
            Text(
                text = stringResource(R.string.left_channel),
                color = AppRes.colors.primary,
                fontSize = 16.sp,
                style = AppRes.type.gilroyMedium
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rightChannel,
                onCheckedChange = {
                    onRightChannelChanged(it)
                },
                colors = CheckboxDefaults.colors().copy(
                    checkedCheckmarkColor = AppRes.colors.background,
                    checkedBoxColor = AppRes.colors.secondary,
                    checkedBorderColor = AppRes.colors.secondary,
                    uncheckedBorderColor = AppRes.colors.secondary
                )
            )
            Text(
                text = stringResource(R.string.right_channel),
                color = AppRes.colors.primary,
                fontSize = 16.sp,
                style = AppRes.type.gilroyMedium
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun ChannelCheckboxesPreview() {
    var left by remember { mutableStateOf(false) }
    var right by remember { mutableStateOf(true) }
    Preview {
        ChannelCheckboxes(
            rightChannel = right,
            leftChannel = left,
            onLeftChannelChanged = { left = !left },
            onRightChannelChanged = { right = !right }
        )
    }
}
