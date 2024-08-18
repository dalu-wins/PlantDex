package de.wins.plantdex.main

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

/**
 * MyApp contains windows size logic. See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 *
 * Sets flags for MyScreen
 *
 * @param windowSizeClass Defines the [WindowSizeClass] of the current screen
 */
@Composable
fun MyApp(windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass) {

    // Determine navigation style
    val showNavigationBar = windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT
    val showNavigationRail = !showNavigationBar

    MyScreen(
        showNavigationBar = showNavigationBar,
        showNavigationRail = showNavigationRail
    )

}