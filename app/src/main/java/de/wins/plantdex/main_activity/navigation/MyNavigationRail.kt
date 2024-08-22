package de.wins.plantdex.main_activity.navigation

import android.content.Intent
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import de.wins.plantdex.scanner_activity.ScannerActivity

@Composable
fun MyNavigationRail(
    onNavigate: (Int) -> Unit,
    navController: NavController
) {
    val context = LocalContext.current
    val items = NavigationItem.LIST
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    NavigationRail(
        modifier = Modifier.displayCutoutPadding(),
        header = {
            ScannerFAB {
                // TODO onEvent
                context.startActivity(Intent(context, ScannerActivity::class.java))
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