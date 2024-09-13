package de.wins.plantdex.scanner.presentation.components

import androidx.compose.material3.FilledIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShutterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier
    ) {
//        Icon(
//            imageVector = Icons.Default.Camera,
//            contentDescription = "Take a photo"
//        )
    }
}