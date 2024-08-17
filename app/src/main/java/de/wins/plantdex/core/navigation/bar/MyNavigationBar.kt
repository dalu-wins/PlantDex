package de.wins.plantdex.core.navigation.bar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.wins.plantdex.core.navigation.ItemPair

@Composable
fun MyNavigationBar() {

    var selectedItem by remember { mutableIntStateOf(0) }
    val items = ItemPair.LIST

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}