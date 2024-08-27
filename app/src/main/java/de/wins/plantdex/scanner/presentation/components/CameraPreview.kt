package de.wins.plantdex.scanner.presentation.components

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner

/**
 * Code for showing a camera preview.
 * Copied from https://medium.com/deuk/from-setup-to-preview-camerax-integration-in-jetpack-compose-b74c18872693
 */
@Composable
fun CameraPreview(modifier: Modifier = Modifier) {

    // Obtain the current context and lifecycle owner
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    // Remember a LifecycleCameraController for this composable
    val cameraController = remember {
        LifecycleCameraController(context).apply {
            // Bind the LifecycleCameraController to the lifecycleOwner
            bindToLifecycle(lifecycleOwner)
        }
    }

    // Key Point: Displaying the Camera Preview
    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            // Initialize the PreviewView and configure it
            PreviewView(ctx).apply {
                scaleType = PreviewView.ScaleType.FILL_CENTER
                implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                controller = cameraController // Set the controller to manage the camera lifecycle
            }
        },
        onRelease = {
            // Release the camera controller when the composable is removed from the screen
            cameraController.unbind()
        }
    )
}