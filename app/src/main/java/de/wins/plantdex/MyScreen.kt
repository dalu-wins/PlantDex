package de.wins.plantdex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import de.wins.plantdex.core.navigation.MyNavHost
import de.wins.plantdex.core.navigation.MyNavigationBar
import de.wins.plantdex.core.navigation.MyNavigationRail
import de.wins.plantdex.core.navigation.NavigationItem

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
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }
    var modifier = Modifier.fillMaxSize()
    if (showNavigationRail) {
        MyNavigationRail(
            selectedItemIndex = selectedItemIndex,
            onNavigate = {
                selectedItemIndex = it
                navController.navigate(NavigationItem.LIST[selectedItemIndex].route)
            }
        )
        modifier = modifier.padding(start = 80.dp)
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (showNavigationBar) {
                MyNavigationBar(
                    selectedItemIndex = selectedItemIndex,
                    onNavigate = {
                        selectedItemIndex = it
                        navController.navigate(NavigationItem.LIST[selectedItemIndex].route)
                    }
                )
            }
        }
    ) { innerPaddingValues ->
        MyNavHost(navController, innerPaddingValues)
    }
}
