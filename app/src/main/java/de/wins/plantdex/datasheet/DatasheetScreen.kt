package de.wins.plantdex.datasheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DatasheetScreen(
    navController: NavController,
    innerPaddingValues: PaddingValues,
    selectedPlantIndex: Int
) {
    Column (
        modifier = Modifier.fillMaxSize().padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "selectedPlantIndex $selectedPlantIndex")
    }
}