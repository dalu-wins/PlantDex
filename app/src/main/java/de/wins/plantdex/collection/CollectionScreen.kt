package de.wins.plantdex.collection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CollectionScreen(
    navController: NavController,
    innerPaddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
    ) {
        items(100) {
            Text(
                text = "Item$it",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
