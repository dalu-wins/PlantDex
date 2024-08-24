package de.wins.plantdex.datasheet.presentation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass

/**
 * [DatasheetApp] contains windows size logic. See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 *
 * Sets flags for [DatasheetScreen]
 *
 * @param windowSizeClass Defines the [WindowSizeClass] of the current screen
 */
@Composable
fun DatasheetApp(
    selectedPlantIndex: Int,
    onBack: () -> Unit,
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {

    // Determine ui style
    val showTopBar = windowSizeClass.windowHeightSizeClass != WindowHeightSizeClass.COMPACT

    DatasheetScreen(
        selectedPlantIndex = selectedPlantIndex,
        onBack = onBack,
        showTopBar = showTopBar
    )

}