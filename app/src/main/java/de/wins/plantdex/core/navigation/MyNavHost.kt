package de.wins.plantdex.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import de.wins.plantdex.plantdex.PlantDexRoute
import de.wins.plantdex.plantdex.PlantDexScreen
import de.wins.plantdex.datasheet.DatasheetRoute
import de.wins.plantdex.datasheet.DatasheetScreen
import de.wins.plantdex.browse.BrowseRoute
import de.wins.plantdex.browse.BrowseScreen
import de.wins.plantdex.profile.ProfileRoute
import de.wins.plantdex.profile.ProfileScreen
import de.wins.plantdex.scanner.ScannerRoute
import de.wins.plantdex.scanner.ScannerScreen

@Composable
fun MyNavHost(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = PlantDexRoute) {
        composable<PlantDexRoute> {
            PlantDexScreen(navController, innerPaddingValues)
        }
        composable<DatasheetRoute> {
            val args = it.toRoute<DatasheetRoute>()
            DatasheetScreen(navController, innerPaddingValues, args.selectedPlantIndex)
        }
        composable<ScannerRoute> {
            ScannerScreen(navController, innerPaddingValues)
        }
        composable<BrowseRoute> {
            BrowseScreen(navController, innerPaddingValues)
        }
        composable<ProfileRoute> {
            ProfileScreen(navController, innerPaddingValues)
        }
    }
}