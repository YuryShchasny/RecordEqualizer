package com.sb.domain.entity

data class Settings(
    val selectedProfileId: Long = -1,
    val selectedInputDevice: Int = -1,
    val selectedOutputDevice: Int = -1,
    val recordMuted: Boolean = false,
    val playbackMuted: Boolean = false,
    val theme: Theme = Theme.DARK,
    val feedbackAlertShown: Boolean = false
) {
    enum class Theme {
        DARK,
        LIGHT
    }
}