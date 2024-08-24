package de.wins.plantdex.datasheet.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import de.wins.plantdex.R

@OptIn(ExperimentalMaterial3Api::class)
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
                TopAppBar(
                    title = {
                        Text(text = context.getString(R.string.datasheet))
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Go back")
                        }
                    }
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