package de.wins.plantdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.wins.plantdex.collection.CollectionRoute
import de.wins.plantdex.collection.CollectionScreen
import de.wins.plantdex.core.theme.PlantDexTheme
import de.wins.plantdex.datasheet.DatasheetRoute
import de.wins.plantdex.datasheet.DatasheetScreen
import de.wins.plantdex.scanner.ScannerRoute
import de.wins.plantdex.scanner.ScannerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantDexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = CollectionRoute) {
                    composable<CollectionRoute> {
                        CollectionScreen(navController)
                    }
                    composable<DatasheetRoute> {
                        val args = it.toRoute<DatasheetRoute>()
                        DatasheetScreen(navController, args.selectedPlantIndex)
                    }
                    composable<ScannerRoute> {
                        ScannerScreen(navController)
                    }
                }
            }
        }
    }
}