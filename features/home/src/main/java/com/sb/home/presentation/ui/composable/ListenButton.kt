package com.sb.home.presentation.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.sb.core.R
import com.sb.core.composable.Preview

@Composable
fun ListenButton(
    isPlaying: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    HomeButton(
        modifier = modifier,
        text = if (isPlaying) stringResource(R.string.stop_listening)
        else stringResource(R.string.start_listening),
        onClick = onClick
    )
}

@PreviewLightDark
@Composable
private fun ListenButtonPreview() {
    var isPlaying by remember { mutableStateOf(false) }
    Preview {
        ListenButton(
            isPlaying = isPlaying,
            onClick = { isPlaying = !isPlaying }
        )
    }
}
