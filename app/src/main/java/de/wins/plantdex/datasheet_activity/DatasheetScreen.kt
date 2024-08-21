package de.wins.plantdex.datasheet_activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DatasheetScreen(
    selectedPlantIndex: Int,
    viewModel: DatasheetViewModel = hiltViewModel()
) {
    val plant = viewModel.getPlant(selectedPlantIndex)
    Scaffold { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "selectedPlantIndex: $selectedPlantIndex")
            Text(text = "name: ${plant.name}")
            Text(text = "date: ${plant.scanDate}")
        }
    }
}