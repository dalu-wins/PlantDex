package de.wins.plantdex.scanner.presentation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass

@Composable
fun ScannerApp(
    onBack: () -> Unit,
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {

    // Determine ui style
    val showTopBar = windowSizeClass.windowHeightSizeClass != WindowHeightSizeClass.COMPACT

    ScannerScreen(
        showTopBar = showTopBar,
        onBack = onBack
    )

}