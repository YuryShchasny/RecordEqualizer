package com.sb.equalizer.presentation.ui.composable

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sb.core.composable.Preview

@Composable
fun BoxScope.DashedLinesColumn(
    height: Dp,
    startValue: Int,
    endValue: Int
) {
    DashedLine(label = "${startValue}dB")
    DashedLine(modifier = Modifier.align(Alignment.Center), label = "${(startValue+endValue)/2}dB")
    DashedLine(modifier = Modifier.align(Alignment.BottomStart), label = "${endValue}dB")
    DashedLine(modifier = Modifier.offset(y = height / 10))
    DashedLine(modifier = Modifier.offset(y = height * 2 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 3 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 4 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 6 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 7 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 8 / 10))
    DashedLine(modifier = Modifier.offset(y = height * 9 / 10))
}

@PreviewLightDark
@Composable
private fun DashedLinesColumnPreview() {
    Preview(
        modifier = Modifier.height(512.dp)
    ) {
        DashedLinesColumn(
            height = 512.dp,
            startValue = 10,
            endValue = -10
        )
    }
}
