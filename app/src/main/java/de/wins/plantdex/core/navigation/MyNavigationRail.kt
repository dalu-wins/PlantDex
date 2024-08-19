package de.wins.plantdex.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import de.wins.plantdex.scanner.ScanFAB

@Composable
fun MyNavigationRail(
    onNavigate: (Int) -> Unit,
    navController: NavController
) {

    val items = NavigationItem.LIST

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    NavigationRail(
        header = {
            ScanFAB {
                navController.navigate(NavigationItem.SCAN.route) {

                }
            }
        }
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = item.route.javaClass.name.equals(currentRoute),
                onClick = { onNavigate(index) }
            )
        }
    }

}