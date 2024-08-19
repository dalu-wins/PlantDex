package de.wins.plantdex.plantdex

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.wins.plantdex.datasheet.DatasheetRoute

@Composable
fun PlantDexScreen(
    navController: NavController,
    innerPaddingValues: PaddingValues,
    viewModel: PlantDexViewModel = hiltViewModel()
) {

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
        if (plantsAsList) {
            LazyColumn {
                items(plants) { plant ->
                    PlantListItem(plant, onClick = {
                        navController.navigate(DatasheetRoute(plants.indexOf(plant)))
                    })
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp)
            ) {
                items(plants) { plant ->
                    PlantCard(plant, onClick = {
                        navController.navigate(DatasheetRoute(plants.indexOf(plant)))
                    })
                }
            }
        }

    }
}
