package de.wins.plantdex.main_activity.ui

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

/**
 * [MainApp] contains windows size logic. See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 *
 * Sets flags for [MainScreen]
 *
 * @param windowSizeClass Defines the [WindowSizeClass] of the current screen
 */
@Composable
fun MainApp(windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass) {

    // Determine navigation style
    val showNavigationBar = windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT
    val showNavigationRail = !showNavigationBar

    // Determine list style
    val listAsCards = windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT
    val doubleColumn = windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED

    MainScreen(
        showNavigationBar = showNavigationBar,
        showNavigationRail = showNavigationRail,
        listAsCards = listAsCards,
        doubleColumn = doubleColumn
    )

}