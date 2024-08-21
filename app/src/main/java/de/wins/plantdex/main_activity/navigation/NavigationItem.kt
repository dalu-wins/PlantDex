package de.wins.plantdex.main_activity.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector
import de.wins.plantdex.main_activity.features.browse.BrowseRoute
import de.wins.plantdex.main_activity.features.plantdex.PlantDexRoute
import de.wins.plantdex.main_activity.features.profile.ProfileRoute

data class NavigationItem(val label: String, val icon: ImageVector, val route: Route) {
    companion object {
        val PLANTDEX = NavigationItem("PlantDex", Icons.Default.AutoAwesomeMosaic, PlantDexRoute)
        val BROWSE = NavigationItem("Browse", Icons.Default.Public, BrowseRoute)
        val PROFILE = NavigationItem("Profile", Icons.Default.AccountCircle, ProfileRoute)

        val LIST = listOf(
            BROWSE,
            PLANTDEX,
            PROFILE
        )
    }
}