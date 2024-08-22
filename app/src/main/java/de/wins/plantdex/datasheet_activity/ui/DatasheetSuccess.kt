package de.wins.plantdex.datasheet_activity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.wins.plantdex.core.Plant

@Composable
fun DatasheetSuccess(plant: Plant, innerPaddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "name: ${plant.name}")
        Text(text = "date: ${plant.scanDate}")
    }
}