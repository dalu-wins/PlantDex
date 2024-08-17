package de.wins.plantdex.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class ItemPair(val label: String, val icon: ImageVector) {
    companion object {
        val LIST = listOf(
            ItemPair("Collection", Icons.Default.AutoAwesomeMosaic),
            ItemPair("Scan", Icons.Default.Grass),
            ItemPair("Settings", Icons.Default.Settings)
        )
    }
}