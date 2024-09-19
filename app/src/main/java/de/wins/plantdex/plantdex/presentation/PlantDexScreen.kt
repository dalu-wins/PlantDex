package de.wins.plantdex.plantdex.presentation

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import de.wins.plantdex.datasheet.DatasheetActivity
import de.wins.plantdex.plantdex.presentation.components.PlantCard
import de.wins.plantdex.plantdex.presentation.components.PlantListItem
import de.wins.plantdex.plantdex.presentation.components.TitleRow

@Composable
fun PlantDexScreen(
    listAsCards: Boolean,
    expandedFAB: MutableState<Boolean>,
    innerPaddingValues: PaddingValues,
    viewModel: PlantDexViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val plants by viewModel.plantRepository.plants.collectAsState()

    // Handle FAB expansion
    val gridState = rememberLazyGridState()
    val firstVisibleItemIndex by remember {
        derivedStateOf { gridState.firstVisibleItemIndex }
    }
    LaunchedEffect(firstVisibleItemIndex) {
        expandedFAB.value = firstVisibleItemIndex == 0
    }

    var myListAsCards by rememberSaveable { mutableStateOf(listAsCards) }

    // TODO Delete later. This line is just for testing how the ui looks
    if (plants.isEmpty()) viewModel.populateWithExamples()

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .padding(horizontal = 8.dp)
    ) {
        TitleRow(
            listAsCards = myListAsCards,
            onPlantsAsListToggled = {
                myListAsCards = !myListAsCards
            }
        )
        val intent = Intent(context, DatasheetActivity::class.java)
        if (myListAsCards) {
            LazyVerticalGrid(
                state = gridState,
                columns = GridCells.Adaptive(minSize = 300.dp)
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
            LazyVerticalGrid(
                state = gridState,
                columns = GridCells.Adaptive(minSize = 500.dp)
            ) {
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
