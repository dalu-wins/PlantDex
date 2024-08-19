package de.wins.plantdex.plantdex

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import de.wins.plantdex.core.data.Plant

@Composable
fun PlantCard(plant: Plant, onClick: () -> Unit) {
    Card(modifier = Modifier
        .padding(6.dp)
        .clickable(onClick = onClick)) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1.4f)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = plant.imageId),
                contentDescription = "placeholder image"
            )
            Row(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, top = 16.dp)) {
                Column(modifier = Modifier.weight(0.9f)) {
                    Text(
                        text = plant.name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = plant.scanDate.toString(),
                        fontWeight = FontWeight.Thin
                    )
                }
                Column(modifier = Modifier.fillMaxHeight()) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.MoreVert, "Show plant actions")
                    }
                }
            }
        }
    }
}