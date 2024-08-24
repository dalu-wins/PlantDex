package de.wins.plantdex.main_activity.features.plantdex

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
    listAsCards: Boolean,
    doubleColumn: Boolean,
    navController: NavController,
    innerPaddingValues: PaddingValues,
    viewModel: PlantDexViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val plants by viewModel.plantRepository.plants.collectAsState()

    var rememberedListAsCards by rememberSaveable { mutableStateOf(listAsCards) }

    // TODO Delete later. This line is just for testing how the ui looks
    if (plants.isEmpty()) viewModel.populateWithExamples()

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .padding(horizontal = 8.dp)
    ) {
        TitleRow(
            listAsCards = listAsCards,
            onPlantsAsListToggled = {
                rememberedListAsCards = !rememberedListAsCards
            }
        )
        val intent = Intent(context, DatasheetActivity::class.java)
        if (rememberedListAsCards) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 240.dp)
            ) {
                items(plants) { plant ->
                    PlantCard(
                        plant = plant,
                        onClick = {
                            // TODO Duplicate Code -> onEvent
                            intent.putExtra("plantIndex", viewModel.getPlantIndex(plant))
                            context.startActivity(intent)
                        }
                    )
                }
            }
        } else {
            val columns = if (doubleColumn) 2 else 1
            LazyVerticalGrid(columns = GridCells.Fixed(columns)) {
                items(plants) { plant ->
                    Log.d("recomposition", "detected recomposition of ${viewModel.getPlantIndex(plant)}")
                    PlantListItem(
                        plant = plant,
                        onClick = {
                            // TODO Duplicate Code -> onEvent
                            intent.putExtra("plantIndex", viewModel.getPlantIndex(plant))
                            context.startActivity(intent)
                        }
                    )
                }
            }
        }

    }
}
