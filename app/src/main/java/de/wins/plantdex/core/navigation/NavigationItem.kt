package de.wins.plantdex.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.AutoAwesomeMosaic
import androidx.compose.ui.graphics.vector.ImageVector
import de.wins.plantdex.collection.CollectionRoute
import de.wins.plantdex.feature_a.FeatureARoute
import de.wins.plantdex.feature_b.FeatureBRoute

data class NavigationItem(val label: String, val icon: ImageVector, val route: Route) {
    companion object {
        val LIST = listOf(
            NavigationItem("Feature A", Icons.Default.Abc, FeatureARoute),
            NavigationItem("PlantDex", Icons.Default.AutoAwesomeMosaic, CollectionRoute),
            NavigationItem("Feature B", Icons.Default.Abc, FeatureBRoute)
        )
    }
}