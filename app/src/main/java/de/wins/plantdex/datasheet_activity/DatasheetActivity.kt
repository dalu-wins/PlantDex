package de.wins.plantdex.datasheet_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import de.wins.plantdex.datasheet_activity.ui.DatasheetApp
import de.wins.plantdex.theme.PlantDexTheme

@AndroidEntryPoint
class DatasheetActivity : ComponentActivity() {

    companion object {
        const val NOT_FOUND = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val plantIndex = intent.getIntExtra("plantIndex", NOT_FOUND)
        enableEdgeToEdge()
        setContent {
            PlantDexTheme {
                DatasheetApp(
                    selectedPlantIndex = plantIndex,
                    onBack = {
                        setResult(RESULT_OK)
                        finish()
                    }
                )
            }
        }
    }
}