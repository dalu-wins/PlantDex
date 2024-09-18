package de.wins.plantdex.scanner.presentation

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import de.wins.plantdex.R
import de.wins.plantdex.scanner.presentation.components.CameraControlRow
import de.wins.plantdex.scanner.presentation.components.CameraPreview
import de.wins.plantdex.scanner.presentation.components.ScannerTopBar
import de.wins.plantdex.scanner.presentation.logic.CameraUIAction
import de.wins.plantdex.scanner.presentation.logic.takePicture
import kotlinx.coroutines.launch

@Composable
fun ScannerScreen(
    showTopBar: Boolean,
    onBack: () -> Unit
) {
    var lensFacing by remember { mutableIntStateOf(CameraSelector.LENS_FACING_BACK) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        // TODO Replace onBack with navigation to a page to enter plant details
        if (uri != null) onImageCaptured(uri, true, onBack)
    }
    var enabledTorch by remember { mutableStateOf(false) }

    // Get the lifecycle of the current context
    val lifecycleOwner = LocalLifecycleOwner.current

    // DisposableEffect to handle lifecycle events
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                enabledTorch = false
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        // Cleanup when the effect leaves the composition
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            if (showTopBar) {
                ScannerTopBar(
                    title = context.getString(R.string.scanner),
                    onBack = onBack,
                    enabledTorch = enabledTorch,
                    onTorch = {
                        enabledTorch = if (lensFacing == CameraSelector.LENS_FACING_BACK) {
                            !enabledTorch
                        } else {
                            false
                        }
                    },
                    isBackCamera = lensFacing == CameraSelector.LENS_FACING_BACK
                )
            }
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CameraPreview(
                lensFacing = lensFacing,
                imageCapture = imageCapture,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.7f)
                    .padding(innerPaddingValues),
                enabledTorch = enabledTorch
            )
            CameraControlRow(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f)
                    .background(color = MaterialTheme.colorScheme.background)
                    .navigationBarsPadding(),
                onCameraUIAction = { cameraUIAction ->
                    when (cameraUIAction) {

                        is CameraUIAction.OnTakePhoto -> {
                            imageCapture.takePicture(
                                context,
                                lensFacing,
                                onImageCaptured = { uri ->
                                    // TODO Replace onBack with navigation to a page to enter plant details
                                    onImageCaptured(uri, false, onBack)
                                },
                                onError = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar("An error occurred while trying to take a picture.")
                                    }
                                }
                            )
                        }

                        is CameraUIAction.OnSwitchLens -> {
                            enabledTorch = false
                            lensFacing =
                                if (lensFacing == CameraSelector.LENS_FACING_BACK) CameraSelector.LENS_FACING_FRONT else CameraSelector.LENS_FACING_BACK
                        }

                        is CameraUIAction.OnOpenGallery -> {
                            enabledTorch = false
                            galleryLauncher.launch("image/*")
                        }
                    }
                }
            )
        }
    }
}

private fun onImageCaptured(uri: Uri, fromGallery: Boolean, navigate: () -> Unit) {
    Log.d(
        "image capture",
        "$uri, $fromGallery"
    )
    navigate()
}