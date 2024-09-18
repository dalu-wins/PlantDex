package de.wins.plantdex.datasheet.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import de.wins.plantdex.core.domain.Plant

@Composable
fun DatasheetSuccess(plant: Plant, innerPaddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = plant.imageId),
            contentDescription = "placeholder image"
        )
        Text(text = "name: ${plant.name}")
        Text(text = "date: ${plant.scanDate}")
    }
}