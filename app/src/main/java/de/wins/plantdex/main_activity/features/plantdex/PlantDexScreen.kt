package de.wins.plantdex.main_activity.features.plantdex

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.wins.plantdex.datasheet_activity.DatasheetActivity

@Composable
fun PlantDexScreen(
    navController: NavController,
    innerPaddingValues: PaddingValues,
    viewModel: PlantDexViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val plants by viewModel.plantRepository.plants.collectAsState()

    var plantsAsList by rememberSaveable { mutableStateOf(false) }

    // TODO Delete later. This line is just for testing how the ui looks
    if (plants.isEmpty()) viewModel.populateWithExamples()

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .padding(horizontal = 16.dp)
    ) {
        TitleRow(
            plantsAsList = plantsAsList,
            onPlantsAsListToggled = {
                plantsAsList = !plantsAsList
            }
        )
        val intent = Intent(context, DatasheetActivity::class.java)
        if (plantsAsList) {
            LazyColumn {
                items(plants) { plant ->
                    PlantListItem(plant, onClick = {
                        intent.putExtra("plantIndex", viewModel.getPlantIndex(plant))
                        context.startActivity(intent)
                    })
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp)
            ) {
                items(plants) { plant ->
                    PlantCard(plant, onClick = {
                        intent.putExtra("plantIndex", viewModel.getPlantIndex(plant))
                        context.startActivity(intent)
                    })
                }
            }
        }

    }
}
