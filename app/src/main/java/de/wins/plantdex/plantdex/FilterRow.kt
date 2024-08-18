package de.wins.plantdex.plantdex

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterRow() {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp).padding(top = 8.dp)
    ) {
        FilterChip(
            selected = false,
            onClick = { /* TODO */ },
            label = { Text(text = "First") },
            trailingIcon = {
                Icon(
                    Icons.Default.ExpandMore,
                    contentDescription = "Show options"
                )
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        FilterChip(
            selected = false,
            onClick = { /* TODO */ },
            label = { Text(text = "Second") },
            trailingIcon = {
                Icon(
                    Icons.Default.ExpandMore,
                    contentDescription = "Show options"
                )
            }
        )
    }
}