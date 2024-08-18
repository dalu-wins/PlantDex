package de.wins.plantdex.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import de.wins.plantdex.collection.CollectionRoute
import de.wins.plantdex.collection.CollectionScreen
import de.wins.plantdex.datasheet.DatasheetRoute
import de.wins.plantdex.datasheet.DatasheetScreen
import de.wins.plantdex.feature_a.FeatureARoute
import de.wins.plantdex.feature_a.FeatureAScreen
import de.wins.plantdex.feature_b.FeatureBRoute
import de.wins.plantdex.feature_b.FeatureBScreen
import de.wins.plantdex.scanner.ScannerRoute
import de.wins.plantdex.scanner.ScannerScreen

@Composable
fun MyNavHost(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = CollectionRoute) {
        composable<CollectionRoute> {
            CollectionScreen(navController, innerPaddingValues)
        }
        composable<DatasheetRoute> {
            val args = it.toRoute<DatasheetRoute>()
            DatasheetScreen(navController, innerPaddingValues, args.selectedPlantIndex)
        }
        composable<ScannerRoute> {
            ScannerScreen(navController, innerPaddingValues)
        }
        composable<FeatureARoute> {
            FeatureAScreen(navController, innerPaddingValues)
        }
        composable<FeatureBRoute> {
            FeatureBScreen(navController, innerPaddingValues)
        }
    }
}