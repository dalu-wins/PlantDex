package de.wins.plantdex.main_activity.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.wins.plantdex.main_activity.features.browse.BrowseRoute
import de.wins.plantdex.main_activity.features.browse.BrowseScreen
import de.wins.plantdex.main_activity.features.plantdex.PlantDexRoute
import de.wins.plantdex.main_activity.features.plantdex.PlantDexScreen
import de.wins.plantdex.main_activity.features.profile.ProfileRoute
import de.wins.plantdex.main_activity.features.profile.ProfileScreen

@Composable
fun MyNavHost(
    listAsCards: Boolean,
    doubleColumn: Boolean,
    navController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = PlantDexRoute) {
        composable<PlantDexRoute> {
            PlantDexScreen(listAsCards, doubleColumn, navController, innerPaddingValues)
        }
        composable<BrowseRoute> {
            BrowseScreen(navController, innerPaddingValues)
        }
        composable<ProfileRoute> {
            ProfileScreen(navController, innerPaddingValues)
        }
    }
}