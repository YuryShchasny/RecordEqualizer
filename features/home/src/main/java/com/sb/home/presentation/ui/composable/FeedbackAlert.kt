package com.sb.home.presentation.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sb.core.R
import com.sb.core.resources.AppRes
import com.sb.core.resources.theme.ColorUiType
import com.sb.core.resources.theme.EqualizerTheme

@Composable
fun FeedbackAlert(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        containerColor = AppRes.colors.backgroundContrast,
        confirmButton = {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onDismissRequest() }
                    .padding(vertical = 4.dp, horizontal = 12.dp),
                text = stringResource(R.string._continue),
                style = AppRes.type.gilroyMedium,
                color = AppRes.colors.primary,
                fontSize = 18.sp,
            )
        },
        dismissButton = {

        },
        title = {
            Text(
                text = stringResource(R.string.feedback_alert_title),
                style = AppRes.type.gilroyBold,
                color = AppRes.colors.secondary,
                fontSize = 22.sp,
            )
        },
        text = {
            Text(
                text = stringResource(R.string.feedback_alert_text),
                style = AppRes.type.gilroy,
                color = AppRes.colors.primary,
                fontSize = 16.sp,
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun FeedbackAlertPreview() {
    EqualizerTheme(colorUiType = if(isSystemInDarkTheme()) ColorUiType.DARK else ColorUiType.LIGHT) {
        FeedbackAlert(
            onDismissRequest = {}
        )
    }
}
