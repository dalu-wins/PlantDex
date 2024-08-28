package de.wins.plantdex.datasheet.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import de.wins.plantdex.R
import de.wins.plantdex.datasheet.presentation.components.DatasheetTopBar

@Composable
fun DatasheetScreen(
    selectedPlantIndex: Int,
    onBack: () -> Unit,
    showTopBar: Boolean,
    viewModel: DatasheetViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val plant = try { viewModel.getPlant(selectedPlantIndex) } catch (e: Exception) { null }
    Scaffold(
        topBar = {
            if (showTopBar) {
                DatasheetTopBar(
                    title = context.getString(R.string.datasheet),
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