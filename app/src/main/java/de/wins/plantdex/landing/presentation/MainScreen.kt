package de.wins.plantdex.landing.presentation

import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import de.wins.plantdex.landing.presentation.navigation.ExtendedScannerFAB
import de.wins.plantdex.landing.presentation.navigation.MyNavHost
import de.wins.plantdex.landing.presentation.navigation.MyNavigationBar
import de.wins.plantdex.landing.presentation.navigation.MyNavigationRail
import de.wins.plantdex.landing.presentation.navigation.NavigationItem
import de.wins.plantdex.scanner.ScannerActivity

/**
 * [MainScreen] defines what the user sees. It operates with the flags defined by [MainApp].
 *
 * See for more information:
 * https://developer.android.com/develop/ui/compose/layouts/adaptive/support-different-screen-sizes
 */
@Composable
fun MainScreen(
    showNavigationBar: Boolean,
    showNavigationRail: Boolean,
    listAsCards: Boolean
) {
    val context = LocalContext.current
    val navController = rememberNavController()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }


    val expandedFAB = rememberSaveable { mutableStateOf(true) }

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
            if (!showNavigationRail) {
                ExtendedScannerFAB(
                    expanded = expandedFAB.value,
                    onClick = {
                        context.startActivity(Intent(context, ScannerActivity::class.java))
                    }
                )
            }
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
            MyNavHost(listAsCards, navController, expandedFAB, innerPaddingValues)
        }
    }
}
