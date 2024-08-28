package de.wins.plantdex.landing.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector
import de.wins.plantdex.browse.presentation.BrowseRoute
import de.wins.plantdex.plantdex.presentation.PlantDexRoute
import de.wins.plantdex.profile.presentation.ProfileRoute

data class NavigationItem(val label: String, val icon: ImageVector, val route: Route) {
    companion object {
        private val PLANTDEX =
            NavigationItem("PlantDex", Icons.Default.AutoAwesomeMosaic, PlantDexRoute)
        private val BROWSE = NavigationItem("Browse", Icons.Default.Public, BrowseRoute)
        private val PROFILE = NavigationItem("Profile", Icons.Default.AccountCircle, ProfileRoute)

        val LIST = listOf(
            BROWSE,
            PLANTDEX,
            PROFILE
        )
    }
}