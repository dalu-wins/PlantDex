package de.wins.plantdex.datasheet.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.wins.plantdex.core.domain.Plant
import de.wins.plantdex.datasheet.presentation.components.InfoColumn

@Composable
fun DatasheetSuccess(plant: Plant, innerPaddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(innerPaddingValues)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.35f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = plant.imageId),
            contentDescription = "plant image"
        )
        InfoColumn(
            plant = plant,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.65f)
                .offset(y = (-24).dp)
        )
    }
}