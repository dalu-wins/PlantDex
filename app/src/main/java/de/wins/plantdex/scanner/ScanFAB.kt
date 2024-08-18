package de.wins.plantdex.scanner

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import de.wins.plantdex.core.navigation.NavigationItem

@Composable
fun ScanFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(NavigationItem.SCAN.icon, NavigationItem.SCAN.label)
    }
}