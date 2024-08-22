package de.wins.plantdex.datasheet_activity.ui

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import de.wins.plantdex.main_activity.ui.MainScreen

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

    // Determine navigation style
    val showTopBar = windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT

    DatasheetScreen(
        selectedPlantIndex = selectedPlantIndex,
        onBack = onBack,
        showTopBar = showTopBar
    )

}