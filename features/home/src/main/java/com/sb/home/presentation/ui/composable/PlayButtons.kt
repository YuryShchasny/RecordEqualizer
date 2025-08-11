package com.sb.home.presentation.ui.composable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.sb.core.composable.Preview

@Composable
fun PlayButtons(
    isPlaying: Boolean,
    isRecordMode: Boolean,
    onListenClick: () -> Unit,
    onRecordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val animationTransition = updateTransition(targetState = isPlaying)
    val listenHeight = animationTransition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessMediumLow) }
    ) { isPlaying ->
        if (isPlaying && isRecordMode) 0.dp else 56.dp
    }
    val recordHeight = animationTransition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessMediumLow) }
    ) { isPlaying ->
        if (isPlaying && !isRecordMode) 0.dp else 56.dp
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ListenButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(listenHeight.value),
            isPlaying = isPlaying && !isRecordMode,
            onClick = onListenClick
        )
        RecordButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(recordHeight.value),
            isPlaying = isPlaying && isRecordMode,
            onClick = onRecordClick
        )
    }
}

@PreviewLightDark
@Composable
private fun PlayButtonsPreview() {
    var isPlaying by remember { mutableStateOf(false) }
    var isRecordMode by remember { mutableStateOf(false) }
    Preview {
        PlayButtons(
            isPlaying = isPlaying,
            isRecordMode = isRecordMode,
            onListenClick = {
                isPlaying = !isPlaying
                isRecordMode = false
            },
            onRecordClick = {
                isPlaying = !isPlaying
                isRecordMode = true
            }
        )
    }
}
