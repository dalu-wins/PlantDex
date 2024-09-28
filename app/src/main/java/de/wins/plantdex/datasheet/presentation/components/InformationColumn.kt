package de.wins.plantdex.datasheet.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.wins.plantdex.core.domain.Plant
import de.wins.plantdex.theme.Typography

@Composable
fun InformationColumn(
    plant: Plant,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.background
            )
            .padding(20.dp)
    ) {
        Text(
            text = plant.name,
            style = Typography.titleMedium
        )
        Text(text = "scanned on ${plant.scanDate}")
    }
}