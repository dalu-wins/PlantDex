
import android.annotation.SuppressLint
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import de.wins.plantdex.scanner.presentation.logic.getCameraProvider
import kotlin.math.max
import kotlin.math.min

@SuppressLint("RestrictedApi")
@Composable
fun CameraPreview(
    imageCapture: ImageCapture,
    modifier: Modifier = Modifier,
    lensFacing: Int = CameraSelector.LENS_FACING_BACK,
    enabledTorch: Boolean = false
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = Preview.Builder().build()
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()

    var camera: Camera? by remember { mutableStateOf(null) }

    // Keep track of zoom level
    var zoomRatio by remember { mutableFloatStateOf(1f) }
    var maxZoom by remember { mutableFloatStateOf(4f) } // You can dynamically get max zoom level from the camera
    val minZoom = 1f // Minimum zoom is 1x (no zoom)

    val previewView = remember { PreviewView(context) }

    // Set up the camera when the lensFacing changes
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        camera = cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture
        )
        preview.setSurfaceProvider(previewView.surfaceProvider)

        // Get the max zoom ratio from the camera once it is bound
        maxZoom = camera?.cameraInfo?.zoomState?.value?.maxZoomRatio ?: maxZoom
    }

    // Set torch when enabledTorch changes
    LaunchedEffect(enabledTorch) {
        camera?.cameraControl?.enableTorch(enabledTorch)
    }

    // Modifier to handle pinch zoom gestures
    val zoomModifier = Modifier.pointerInput(Unit) {
        detectTransformGestures { _, _, zoomChange, _ ->
            val newZoom = zoomRatio * zoomChange
            zoomRatio = max(minZoom, min(newZoom, maxZoom))
            camera?.cameraControl?.setZoomRatio(zoomRatio) // Set the zoom ratio in the camera
        }
    }

    // AndroidView to display the camera preview with the zoom functionality
    AndroidView(
        factory = { previewView },
        modifier = modifier.then(zoomModifier) // Attach zoom gesture handler
    )
}
