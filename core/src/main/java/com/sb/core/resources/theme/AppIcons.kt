package com.sb.core.resources.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.sb.core.resources.icons.FloppyDiskIcon
import com.sb.core.resources.icons.MoonIcon
import com.sb.core.resources.icons.PauseIcon
import com.sb.core.resources.icons.PlayIcon
import com.sb.core.resources.icons.SlidersUpIcon
import com.sb.core.resources.icons.SunIcon
import com.sb.core.resources.icons.TrashIcon
import com.sb.core.resources.icons.VolumeOff
import com.sb.core.resources.icons.VolumeOn

@Immutable
data class AppIcons(
    val play: ImageVector = PlayIcon,
    val pause: ImageVector = PauseIcon,
    val slidersUp: ImageVector = SlidersUpIcon,
    val moon: ImageVector = MoonIcon,
    val sun: ImageVector = SunIcon,
    val save: ImageVector = FloppyDiskIcon,
    val trash: ImageVector = TrashIcon,
    val volumeOn: ImageVector = VolumeOn,
    val volumeOff: ImageVector = VolumeOff,
)

val baseAppIcons = AppIcons()

val LocalAppIcons = staticCompositionLocalOf<AppIcons> {
    error("Icons is not provided")
}