package de.wins.plantdex.landing.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.wins.plantdex.browse.presentation.BrowseRoute
import de.wins.plantdex.browse.presentation.BrowseScreen
import de.wins.plantdex.plantdex.presentation.PlantDexRoute
import de.wins.plantdex.plantdex.presentation.PlantDexScreen
import de.wins.plantdex.profile.presentation.ProfileRoute
import de.wins.plantdex.profile.presentation.ProfileScreen

@Composable
fun MyNavHost(
    listAsCards: Boolean,
    doubleColumn: Boolean,
    navController: NavHostController,
    expandedFAB: MutableState<Boolean>,
    innerPaddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = PlantDexRoute) {
        composable<PlantDexRoute> {
            PlantDexScreen(
                listAsCards,
                doubleColumn,
                navController,
                expandedFAB,
                innerPaddingValues
            )
        }
        composable<BrowseRoute> {
            BrowseScreen(navController, innerPaddingValues)
        }
        composable<ProfileRoute> {
            ProfileScreen(navController, innerPaddingValues)
        }
    }
}