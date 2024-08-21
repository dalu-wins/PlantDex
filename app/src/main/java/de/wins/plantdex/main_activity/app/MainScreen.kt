package de.wins.plantdex.main_activity.app

import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import de.wins.plantdex.main_activity.navigation.MyNavHost
import de.wins.plantdex.main_activity.navigation.MyNavigationBar
import de.wins.plantdex.main_activity.navigation.MyNavigationRail
import de.wins.plantdex.main_activity.navigation.NavigationItem
import de.wins.plantdex.scanner_activity.ScanFAB
import de.wins.plantdex.scanner_activity.ScannerActivity

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
    val context = LocalContext.current
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
                    context.startActivity(Intent(context, ScannerActivity::class.java))
                }
            )
        }
    ) { innerPaddingValues ->
        Row {
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
            }
            MyNavHost(navController, innerPaddingValues)
        }
    }
}
