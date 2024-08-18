package de.wins.plantdex.plantdex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import de.wins.plantdex.R
import de.wins.plantdex.core.data.Plant

@Composable
fun PlantDexScreen(
    navController: NavController,
    innerPaddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .padding(horizontal = 16.dp),
    ) {
        FilterRow()
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp)
        ) {
            items(100) {
                PlantCard(Plant("MyPlant $it", "Region", R.drawable.placeholder))
            }
        }
    }
}
