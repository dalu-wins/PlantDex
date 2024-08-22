package de.wins.plantdex.main_activity.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun ScannerFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(Icons.Default.Grass, "Open camera")
    }
}