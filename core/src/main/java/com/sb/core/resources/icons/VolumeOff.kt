package com.sb.core.resources.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val VolumeOff: ImageVector
    get() {
        if (_VolumeOff != null) {
            return _VolumeOff!!
        }
        _VolumeOff = ImageVector.Builder(
            name = "VolumeOff",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(16f, 9.5f)
                lineTo(21f, 14.5f)
                moveTo(21f, 9.5f)
                lineTo(16f, 14.5f)
                moveTo(4.6f, 9f)
                horizontalLineTo(5.501f)
                curveTo(6.052f, 9f, 6.328f, 9f, 6.583f, 8.931f)
                curveTo(6.809f, 8.871f, 7.023f, 8.77f, 7.214f, 8.636f)
                curveTo(7.43f, 8.484f, 7.607f, 8.272f, 7.96f, 7.849f)
                lineTo(10.585f, 4.698f)
                curveTo(11.021f, 4.175f, 11.239f, 3.913f, 11.429f, 3.886f)
                curveTo(11.594f, 3.863f, 11.76f, 3.923f, 11.871f, 4.046f)
                curveTo(12f, 4.189f, 12f, 4.529f, 12f, 5.21f)
                verticalLineTo(18.79f)
                curveTo(12f, 19.471f, 12f, 19.811f, 11.871f, 19.954f)
                curveTo(11.76f, 20.078f, 11.594f, 20.138f, 11.429f, 20.114f)
                curveTo(11.239f, 20.087f, 11.021f, 19.825f, 10.585f, 19.303f)
                lineTo(7.96f, 16.152f)
                curveTo(7.607f, 15.728f, 7.43f, 15.517f, 7.214f, 15.365f)
                curveTo(7.023f, 15.23f, 6.809f, 15.13f, 6.583f, 15.069f)
                curveTo(6.328f, 15f, 6.052f, 15f, 5.501f, 15f)
                horizontalLineTo(4.6f)
                curveTo(4.04f, 15f, 3.76f, 15f, 3.546f, 14.891f)
                curveTo(3.358f, 14.795f, 3.205f, 14.642f, 3.109f, 14.454f)
                curveTo(3f, 14.24f, 3f, 13.96f, 3f, 13.4f)
                verticalLineTo(10.6f)
                curveTo(3f, 10.04f, 3f, 9.76f, 3.109f, 9.546f)
                curveTo(3.205f, 9.358f, 3.358f, 9.205f, 3.546f, 9.109f)
                curveTo(3.76f, 9f, 4.04f, 9f, 4.6f, 9f)
                close()
            }
        }.build()

        return _VolumeOff!!
    }

@Suppress("ObjectPropertyName")
private var _VolumeOff: ImageVector? = null
