package de.wins.plantdex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.wins.plantdex.core.navigation.MyNavHost
import de.wins.plantdex.core.navigation.bar.MyNavigationBar
import de.wins.plantdex.core.navigation.rail.MyNavigationRail

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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = { if (showNavigationBar) MyNavigationBar() },
        ) { innerPaddingValues ->
            MyNavHost(innerPaddingValues)
        }
        if (showNavigationRail) MyNavigationRail()
    }

}