package de.wins.plantdex.scanner_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import de.wins.plantdex.scanner_activity.ui.ScannerScreen
import de.wins.plantdex.theme.PlantDexTheme

@AndroidEntryPoint
class ScannerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantDexTheme {
                ScannerScreen()
            }
        }
    }
}