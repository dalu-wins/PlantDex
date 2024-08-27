package de.wins.plantdex.scanner.presentation

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import de.wins.plantdex.R
import de.wins.plantdex.core.presentation.MyTopBar
import de.wins.plantdex.scanner.presentation.components.CameraControlRow
import de.wins.plantdex.scanner.presentation.components.CameraPreview
import de.wins.plantdex.scanner.presentation.logic.CameraUIAction
import de.wins.plantdex.scanner.presentation.logic.takePicture
import kotlinx.coroutines.launch

@Composable
fun ScannerScreen(
    showTopBar: Boolean,
    onBack: () -> Unit,
    lensFacing: Int = CameraSelector.LENS_FACING_BACK
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            if (showTopBar) {
                MyTopBar(
                    title = context.getString(R.string.scanner),
                    onBack = onBack
                )
            }
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CameraPreview(
                imageCapture = imageCapture,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.7f)
            )
            CameraControlRow(
                onCameraUIAction = { cameraUIAction ->
                    when (cameraUIAction) {
                        is CameraUIAction.OnShutterClick -> {
                            imageCapture.takePicture(
                                context,
                                lensFacing,
                                onImageCaptured = { uri, fromGallery ->
                                    Log.d(
                                        "TAG",
                                        "Image Uri Captured from Camera View"
                                    ) //Todo : use the uri as needed
                                }, onError = { imageCaptureException ->
                                    scope.launch {
                                        snackbarHostState.showSnackbar("An error occurred while trying to take a picture")
                                    }
                                })
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f),
            )
        }
    }
}