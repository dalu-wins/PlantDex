package de.wins.plantdex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    var modifier = Modifier.fillMaxSize()
    if (showNavigationRail) {
        MyNavigationRail()
        modifier = modifier.padding(start = 80.dp)
    }

    Scaffold(
        modifier = modifier,
        bottomBar = { if (showNavigationBar) MyNavigationBar() },
    ) { innerPaddingValues ->
        MyNavHost(innerPaddingValues)
    }
}