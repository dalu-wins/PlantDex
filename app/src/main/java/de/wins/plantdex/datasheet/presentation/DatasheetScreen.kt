package de.wins.plantdex.datasheet.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import de.wins.plantdex.datasheet.presentation.components.DatasheetTopBar

@Composable
fun DatasheetScreen(
    selectedPlantIndex: Int,
    onBack: () -> Unit,
    showTopBar: Boolean,
    viewModel: DatasheetViewModel = hiltViewModel()
) {
    val plant = try { viewModel.getPlant(selectedPlantIndex) } catch (e: Exception) { null }
    Scaffold(
        topBar = {
            if (showTopBar) {
                DatasheetTopBar(
                    onBack = onBack
                )
            }
        }
    ) { innerPaddingValues ->
        if (plant == null) {
            DatasheetError(onBack, innerPaddingValues)
        } else {
            DatasheetSuccess(plant, innerPaddingValues)
        }
    }
}