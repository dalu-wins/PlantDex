package de.wins.plantdex.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector
import de.wins.plantdex.browse.BrowseRoute
import de.wins.plantdex.collection.CollectionRoute
import de.wins.plantdex.profile.ProfileRoute
import de.wins.plantdex.scanner.ScannerRoute

data class NavigationItem(val label: String, val icon: ImageVector, val route: Route) {
    companion object {
        val PLANTDEX = NavigationItem("PlantDex", Icons.Default.AutoAwesomeMosaic, CollectionRoute)
        val SCAN = NavigationItem("Scan", Icons.Default.Grass, ScannerRoute)
        val BROWSE = NavigationItem("Browse", Icons.Default.Public, BrowseRoute)
        val PROFILE = NavigationItem("Profile", Icons.Default.AccountCircle, ProfileRoute)

        val LIST = listOf(
            BROWSE,
            PLANTDEX,
            PROFILE,
            SCAN
        )
        val NAVIGATION_LIST = LIST.take(3)
    }
}