package de.wins.plantdex.scanner.presentation.components

import android.annotation.SuppressLint
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import de.wins.plantdex.scanner.presentation.logic.getCameraProvider

@SuppressLint("RestrictedApi")
@Composable
fun CameraPreview(
    imageCapture: ImageCapture,
    modifier: Modifier = Modifier,
    lensFacing: Int = CameraSelector.LENS_FACING_BACK
) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = Preview.Builder().build()
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()

    val previewView = remember { PreviewView(context) }
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture
        )
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }

    AndroidView({ previewView }, modifier = modifier)
}