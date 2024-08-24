package de.wins.plantdex.plantdex.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TitleRow(
    listAsCards: Boolean,
    onPlantsAsListToggled: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "My Plants",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(8.dp)
        )
        if (listAsCards) {
            IconButton(onClick = { onPlantsAsListToggled() }) {
                Icon(Icons.AutoMirrored.Filled.List, "Switch between dashboard and list view")
            }
        } else {
            IconButton(onClick = { onPlantsAsListToggled() }) {
                Icon(Icons.Default.Dashboard, "Switch between dashboard and list view")
            }
        }
    }
}