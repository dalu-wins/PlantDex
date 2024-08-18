package de.wins.plantdex.core.navigation.rail

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.wins.plantdex.core.navigation.items.ItemPair

@Composable
fun MyNavigationRail() {

    var selectedItem by remember { mutableIntStateOf(0) }
    val items = ItemPair.LIST

    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }

}