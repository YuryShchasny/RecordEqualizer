package com.sb.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sb.core.resources.AppRes
import com.sb.core.resources.theme.ColorUiType
import com.sb.core.resources.theme.EqualizerTheme

@Composable
fun Preview(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    EqualizerTheme(
        colorUiType = if (isSystemInDarkTheme()) ColorUiType.DARK else ColorUiType.LIGHT,
    ) {
        Box(
            modifier = Modifier
                .background(AppRes.colors.background)
                .then(modifier),
            content = content
        )
    }
}