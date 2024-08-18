package de.wins.plantdex.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import de.wins.plantdex.scanner.ScanFAB

@Composable
fun MyNavigationRail(
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit
) {

    val items = NavigationItem.NAVIGATION_LIST

    NavigationRail(
        header = {
            ScanFAB {
                onNavigate(NavigationItem.LIST.indexOf(NavigationItem.SCAN))
            }
        }
    ) {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItemIndex == index,
                onClick = { onNavigate(index) }
            )
        }
    }

}