package de.wins.plantdex.main

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
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import de.wins.plantdex.core.navigation.MyNavHost
import de.wins.plantdex.core.navigation.MyNavigationBar
import de.wins.plantdex.core.navigation.MyNavigationRail
import de.wins.plantdex.core.navigation.NavigationItem
import de.wins.plantdex.scanner.ScanFAB

/**
 * MyScreen defines what the user sees. It operates with the flags defined by MyApp.
 *
 * See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 */
@Composable
fun MainScreen(
    showNavigationBar: Boolean,
    showNavigationRail: Boolean
) {
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }

    var scaffoldModifier = Modifier.fillMaxSize()
    if (showNavigationRail) {
        MyNavigationRail(
            onNavigate = {
                selectedItemIndex = it
                navController.navigate(NavigationItem.LIST[selectedItemIndex].route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            navController = navController
        )
        scaffoldModifier = scaffoldModifier.padding(start = 80.dp)
    }

    Scaffold(
        modifier = scaffoldModifier,
        bottomBar = {
            if (showNavigationBar) {
                MyNavigationBar(
                    onNavigate = {
                        selectedItemIndex = it
                        navController.navigate(NavigationItem.LIST[selectedItemIndex].route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    navController = navController
                )
            }
        },
        floatingActionButton = {
            if (!showNavigationRail) ScanFAB(
                onClick = {
                    navController.navigate(NavigationItem.SCAN.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPaddingValues ->
        MyNavHost(navController, innerPaddingValues)
    }
}
