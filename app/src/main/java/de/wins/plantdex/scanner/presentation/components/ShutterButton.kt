package de.wins.plantdex.scanner.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShutterButton(
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.PhotoCamera,
            contentDescription = "Take a photo"
        )
    }
}