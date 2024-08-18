package de.wins.plantdex.core.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MyNavigationBar(
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit
) {
    val items = NavigationItem.NAVIGATION_LIST

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItemIndex == index,
                onClick = { onNavigate(index) }
            )
        }
    }
}