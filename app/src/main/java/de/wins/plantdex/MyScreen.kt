package de.wins.plantdex

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import de.wins.plantdex.core.navigation.MyNavHost
import de.wins.plantdex.core.navigation.bar.MyNavigationBar

/**
 * MyScreen defines what the user sees. It operates with the flags defined by MyApp.
 *
 * See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 */
@Composable
fun MyScreen(
    showNavigationBar: Boolean,
    showNavigationRail: Boolean
) {
    Scaffold(
        bottomBar = { if (showNavigationBar) MyNavigationBar() },
    ) { innerPaddingValues ->
        MyNavHost(innerPaddingValues)
    }
}