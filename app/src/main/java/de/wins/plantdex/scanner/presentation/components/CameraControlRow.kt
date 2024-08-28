package de.wins.plantdex.scanner.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.wins.plantdex.scanner.presentation.logic.CameraUIAction

@Composable
fun CameraControlRow(
    onCameraUIAction: (CameraUIAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GalleryButton(
            modifier = Modifier
                .size(60.dp)
                .aspectRatio(1f),
            onClick = {
                onCameraUIAction(CameraUIAction.OnOpenGallery)
            }
        )
        Spacer(modifier = Modifier.size(30.dp))
        ShutterButton(
            modifier = Modifier
                .size(60.dp)
                .aspectRatio(1f),
            onClick = {
                onCameraUIAction(CameraUIAction.OnTakePhoto)
            }
        )
        Spacer(modifier = Modifier.size(30.dp))
        SwitchLensButton(
            modifier = Modifier
                .size(60.dp)
                .aspectRatio(1f),
            onClick = {
                onCameraUIAction(CameraUIAction.OnSwitchLens)
            }
        )
    }
}